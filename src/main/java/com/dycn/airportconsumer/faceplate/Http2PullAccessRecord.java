package com.dycn.airportconsumer.faceplate;

import com.dycn.airportconsumer.faceplate.common.ConnectionStatus;
import com.dycn.airportconsumer.faceplate.common.HttpEventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Http2PullAccessRecord implements IRecordsEventManager {
    private static final Logger mLogger = LoggerFactory.getLogger(Http2PullAccessRecord.class);

    private HttpConnection mHttpConnection;
    private Http2ClientHandler mHttp2ClientHandler;

    //access_records相关的参数
    public static String mApiVersion = "1.0";
    private String mCheckpoint;
    private String mRecordsType;
    private long mFromTimestamp;


    public Http2PullAccessRecord(HttpConnection httpConnection, String checkpoint, String recordsType, long fromTimeStamp, String apiVersion) {
        mHttpConnection = httpConnection;
        mHttp2ClientHandler = mHttpConnection.getInitializer().getHttp2ClientHandler();
        this.mCheckpoint = checkpoint;
        this.mFromTimestamp = fromTimeStamp;
        mApiVersion = apiVersion;
        this.mRecordsType = recordsType;
    }

    @Override
    public void subscribeRecordEvents(String url, String username, String password, IRecordEventHandler handler)
            throws UnsupportedOperationException, SGHttp2Exceptions.NetworkException, SGHttp2Exceptions.OperationException, SGHttp2Exceptions.DeviceException {
        mHttp2ClientHandler.subscribeAccessRecordEvent(handler);




        mHttp2ClientHandler.getRecords(url, username, password, mCheckpoint, mRecordsType, mApiVersion, mFromTimestamp);

        //如果连接状态断开了，取消订阅
        mHttp2ClientHandler.setConnectionHandler(connectionStatus -> {
            if(ConnectionStatus.DISCONNECTED.equals(connectionStatus)){
                mLogger.info("DISCONNECTED");
                unsubscribeEvent(HttpEventType.ACCESS_RECORD);
            }
        });
    }

    /**
     * 取消事件订阅
     *
     * @param type
     */
    @Override
    public void unsubscribeEvent(HttpEventType type) {
        mHttp2ClientHandler.unsubscribeEvent(type);
    }
}
