package com.dycn.airportconsumer.faceplate;

import com.dycn.airportconsumer.faceplate.avro.RecentRecord;
import com.dycn.airportconsumer.faceplate.sream.handler.StreamRecordHandler;
import io.netty.buffer.ByteBuf;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.specific.SpecificRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * 过人日志可执行类
 */
public class RecentRecordStreamHandler extends StreamRecordHandler {
    private static final Logger mLogger = LoggerFactory.getLogger(RecentRecordStreamHandler.class);
    public static boolean isFetchApi = false;
    public static volatile String schemaString;

    public RecentRecordStreamHandler(IRecordsEventManager.IRecordEventHandler accessRecordEventHandler, String host, BlockingQueue<ByteBuf> recordQueue) {
        super(accessRecordEventHandler, host, recordQueue);
    }

    /**
     * 近照记录处理接口，解析数据
     */
    @Override
    public SpecificRecord parseRecord(byte[] data) throws Exception {
        RecentRecord recentRecord = new RecentRecord();
        List<GenericRecord> newRecords = AvroUtil.decode(recentRecord.getSchema(), data);
        mLogger.info("getRecentRecord newRecords {} ", newRecords == null ? null : newRecords.hashCode());
        mLogger.info("getRecentRecord newRecords size " + newRecords.size());
        if (newRecords != null && newRecords.size() > 0) {
            recentRecord = (RecentRecord) newRecords.get(0);

            mLogger.info("Received Record success");
            mLogger.info("ID: " + recentRecord.getID() + " personId: " + recentRecord.getPersonId() + " createTime: " + recentRecord.getCreateDateTime());
        }
        return recentRecord;
    }


}
