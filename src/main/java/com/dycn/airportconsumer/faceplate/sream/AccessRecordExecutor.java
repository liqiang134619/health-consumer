package com.dycn.airportconsumer.faceplate.sream;

import com.dycn.airportconsumer.faceplate.IRecordsEventManager;
import com.dycn.airportconsumer.faceplate.sream.handler.AccessRecordStreamHandler;
import com.dycn.airportconsumer.faceplate.sream.handler.StreamRecordHandler;
import io.netty.buffer.ByteBuf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 各种record执行类
 */
public class AccessRecordExecutor extends StreamRecordsExecutor {
    private static final Logger mLogger = LoggerFactory.getLogger(AccessRecordExecutor.class);


    /**
     * 不同的构造函数传入handler
     */
    public AccessRecordExecutor(IRecordsEventManager.IRecordEventHandler accessRecordEventHandler, String host) {
        super(accessRecordEventHandler, host);
    }

    @Override
    protected StreamRecordHandler buildStreamRecordHandler(IRecordsEventManager.IRecordEventHandler recordEventHandler, String host) {
        return new AccessRecordStreamHandler(recordEventHandler, host, mRecordRawDataQueue);
    }


    /**
     * 过人日志处理接口
     */
    public void processAccessRecord(ByteBuf data, String schemaString, boolean isFetchApi) throws Exception {
        super.processRecord(data);
        AccessRecordStreamHandler.schemaString = schemaString;
        AccessRecordStreamHandler.isFetchApi = isFetchApi;

    }
}
