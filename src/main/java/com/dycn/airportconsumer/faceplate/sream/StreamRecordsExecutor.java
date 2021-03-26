package com.dycn.airportconsumer.faceplate.sream;

import com.dycn.airportconsumer.faceplate.IRecordsEventManager;
import com.dycn.airportconsumer.faceplate.common.HttpEventType;
import com.dycn.airportconsumer.faceplate.sream.handler.StreamRecordHandler;
import io.netty.buffer.ByteBuf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 各种record执行类
 */
public abstract class StreamRecordsExecutor {
    private static final Logger mLogger = LoggerFactory.getLogger(StreamRecordsExecutor.class);
    private StreamRecordHandler mStreamRecordHandler;
    protected final BlockingQueue<ByteBuf> mRecordRawDataQueue = new LinkedBlockingQueue<ByteBuf>(100000);

    /**
     * 不同的构造函数传入handler
     */
    public StreamRecordsExecutor(IRecordsEventManager.IRecordEventHandler recordEventHandler, String host) {
        mStreamRecordHandler = buildStreamRecordHandler(recordEventHandler, host);
        mStreamRecordHandler.start();
        mLogger.info("IRecordEventHandler start, host:{}", host);
    }

    /**
     * 创建一个具体的handler
     * @param recordEventHandler
     * @param host
     * @return
     */
    abstract protected StreamRecordHandler buildStreamRecordHandler(IRecordsEventManager.IRecordEventHandler recordEventHandler, String host);

    public void terminate(HttpEventType type) throws UnsupportedOperationException {
        mStreamRecordHandler.terminate();
    }

    /**
     * 获取数据接口
     */
    public void processRecord(ByteBuf data) throws Exception {
        mRecordRawDataQueue.put(data);
    }
}
