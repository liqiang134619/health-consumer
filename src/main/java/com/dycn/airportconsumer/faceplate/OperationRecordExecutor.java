package com.dycn.airportconsumer.faceplate;

import com.dycn.airportconsumer.faceplate.sream.StreamRecordsExecutor;
import com.dycn.airportconsumer.faceplate.sream.handler.StreamRecordHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OperationRecordExecutor extends StreamRecordsExecutor {
    private static final Logger mLogger = LoggerFactory.getLogger(OperationRecordExecutor.class);

    /**
     * 不同的构造函数传入handler
     */
    public OperationRecordExecutor(IRecordsEventManager.IRecordEventHandler recentRecordEventHandler, String host) {
        super(recentRecordEventHandler, host);
    }

    @Override
    protected StreamRecordHandler buildStreamRecordHandler(IRecordsEventManager.IRecordEventHandler recordEventHandler, String host) {
        return new OperationRecordStreamHandler(recordEventHandler, host, mRecordRawDataQueue);
    }
}
