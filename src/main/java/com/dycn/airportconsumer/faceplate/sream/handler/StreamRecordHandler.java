package com.dycn.airportconsumer.faceplate.sream.handler;

import com.dycn.airportconsumer.faceplate.IRecordsEventManager;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.apache.avro.specific.SpecificRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

/**
 * 日志可执行类
 */
public abstract class StreamRecordHandler extends Thread{
    private static final Logger mLogger = LoggerFactory.getLogger(StreamRecordHandler.class);
    private IRecordsEventManager.IRecordEventHandler mCallbackHandler;
    private ByteBuf mRecordIdBytes; // 每条过人记录frame
    private boolean mIsStreamStarted = true; //判断这条frame里面是否包含一条新的过人记录
    private int mDataLength; //一条过人记录的长度
    private final int LENGTH_BYTE = 4; // 有4个byte用来保持记录的长度
    private String deviceHost;

    protected final BlockingQueue<ByteBuf> mRecordQueue;
    private volatile boolean running = true;

    public static volatile String schemaString;

    public StreamRecordHandler(IRecordsEventManager.IRecordEventHandler recordEventHandler, String host, BlockingQueue<ByteBuf> recordQueue) {
        this.mCallbackHandler = recordEventHandler;
        this.deviceHost = host;
        this.mRecordQueue = recordQueue;
    }


    public void terminate() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                ByteBuf data = mRecordQueue.take(); // 从队列中取一条记录
                //mLogger.info("data length:{}",data.readableBytes());
                //mLogger.info("Take one data on host: {}, mIsStreamStarted: {}", deviceHost, mIsStreamStarted);

                if (mIsStreamStarted) {
                    if (mRecordIdBytes == null) {
                        mRecordIdBytes = data;
                    } else {
                        ByteBuf tmp = Unpooled.copiedBuffer(mRecordIdBytes, data);
                        data.release();
                        mRecordIdBytes.release();
                        mRecordIdBytes = tmp;
                    }
                    mDataLength = mRecordIdBytes.readInt();
                    mIsStreamStarted = false;
                } else {
                    ByteBuf tmp =  Unpooled.copiedBuffer(mRecordIdBytes, data);
                    data.release();
                    mRecordIdBytes.release();
                    mRecordIdBytes = tmp;
                }

                // mLogger.info("host: {}, readableBytes: {} , mDataLength is {}", deviceHost, mRecordIdBytes.readableBytes(), mDataLength);
                if (mRecordIdBytes.readableBytes() >= mDataLength) {
                    // mLogger.info("host: {}, readableBytes: {} , mDataLength is {}", deviceHost, mRecordIdBytes.readableBytes(), mDataLength);
                    int contentLength = mRecordIdBytes.readableBytes(); // 记录当前累计总长度
                    byte[] arr = new byte[mDataLength]; // 新建一个byte数组来存储一条记录
                    mRecordIdBytes.readBytes(arr);

                    SpecificRecord accessRecordResult = parseRecord(arr);
                    if (mCallbackHandler != null) {
                        mCallbackHandler.onRecord(accessRecordResult);
                    } else {
                        mLogger.info("host: {} mCallbackHandler is null", deviceHost);
                    }

                    int recordIndex = mRecordIdBytes.readerIndex();
                    mLogger.info("生成一条记录： 设备IP(or设备ID): {}, 当前记录总长度：{}, 记录游标：{}", deviceHost, contentLength, recordIndex);

                    if (contentLength - recordIndex >= LENGTH_BYTE) { // 下一条记录的长度还在该frame中
                        mRecordIdBytes = mRecordIdBytes.slice(recordIndex, contentLength - recordIndex);
                        mDataLength = mRecordIdBytes.readInt();
                        mIsStreamStarted = false;
                    } else if (contentLength - recordIndex > 0) {
                        // 下一条记录的长度还在该frame中，但是int长度不足4，需要与下一帧拼接才能得到下一帧长度
                        mRecordIdBytes = mRecordIdBytes.slice(recordIndex, contentLength - recordIndex);
                        mIsStreamStarted = true;
                    } else { // 下一条是一个完整的记录
                        mRecordIdBytes = null;
                        mIsStreamStarted = true;
                    }
                }
            } catch (Exception e) {
                mLogger.error("Stopping AccessRecordThread, cause: {}", e.getMessage());
                running = false;
            }
        }
        mLogger.info("AccessRecordThread stopped!");
    }


    abstract protected SpecificRecord parseRecord(byte[] data) throws  Exception;
}
