package com.dycn.airportconsumer.faceplate;

import com.dycn.airportconsumer.faceplate.avro.OperationRecord;
import com.dycn.airportconsumer.faceplate.sream.handler.StreamRecordHandler;
import io.netty.buffer.ByteBuf;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.specific.SpecificRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * 操作日志
 */
public class OperationRecordStreamHandler extends StreamRecordHandler {
    private static final Logger mLogger = LoggerFactory.getLogger(OperationRecordStreamHandler.class);

    public OperationRecordStreamHandler(IRecordsEventManager.IRecordEventHandler recordEventHandler, String host, BlockingQueue<ByteBuf> recordQueue) {
        super(recordEventHandler, host, recordQueue);
    }

    /**
     * 操作记录处理接口，解析数据
     */
    @Override
    public SpecificRecord parseRecord(byte[] data) throws Exception {
        OperationRecord operationRecord = new OperationRecord();
        List<GenericRecord> newRecords = AvroUtil.decode(operationRecord.getSchema(), data);
        mLogger.info("getRecentRecord newRecords size " + newRecords.size());
        if (newRecords != null && newRecords.size() > 0) {
            operationRecord = (OperationRecord) newRecords.get(0);

            mLogger.info("Received Record: " + String.valueOf(operationRecord));
        }
        return operationRecord;
    }


}
