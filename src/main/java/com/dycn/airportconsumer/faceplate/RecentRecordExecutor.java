package com.dycn.airportconsumer.faceplate;

import com.dycn.airportconsumer.faceplate.sream.StreamRecordsExecutor;
import com.dycn.airportconsumer.faceplate.sream.handler.StreamRecordHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecentRecordExecutor extends StreamRecordsExecutor {
    private static final Logger mLogger = LoggerFactory.getLogger(RecentRecordExecutor.class);

    /**
     * 不同的构造函数传入handler
     */
    public RecentRecordExecutor(IRecordsEventManager.IRecordEventHandler recentRecordEventHandler, String host) {
        super(recentRecordEventHandler, host);
    }

    @Override
    protected StreamRecordHandler buildStreamRecordHandler(IRecordsEventManager.IRecordEventHandler recordEventHandler, String host) {
        return new RecentRecordStreamHandler(recordEventHandler, host, mRecordRawDataQueue);
    }
}
