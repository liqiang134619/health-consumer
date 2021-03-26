package com.dycn.airportconsumer.faceplate;

import com.dycn.healthairport.faceplate.common.ConnectionStatus;
import com.dycn.healthairport.faceplate.common.HttpEventType;
import org.apache.avro.specific.SpecificRecord;

/**
 * 事件管理接口类
 * 流式API的管理接口
 */
public interface IRecordsEventManager {
    /**
     * 日志事件的Eventhandler接口
     */
    interface IRecordEventHandler {
        /**
         * 日志回调
         *
         * @param record
         */
        void onRecord(SpecificRecord record);
    }


    /**
     * 订阅事件
     *
     * @param handler
     */
    void subscribeRecordEvents(String url, String username, String password, IRecordEventHandler handler)
            throws UnsupportedOperationException, SGHttp2Exceptions.NetworkException, SGHttp2Exceptions.OperationException, SGHttp2Exceptions.DeviceException;


    /**
     * 连接状态事件的Eventhandler接口
     */
    interface IConnectionStatusEventHandler {
        /**
         * 连接状态回调
         *
         * @param connectionStatus
         */
        void onConnectionStatusChanged(ConnectionStatus connectionStatus);
    }

    void unsubscribeEvent(HttpEventType type);
}
