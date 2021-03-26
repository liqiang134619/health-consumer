package com.dycn.airportconsumer.faceplate.common;

/**
 * @author Liq
 * @date 2021/1/23
 */
public class HttpDefine {
    // Http相关配置
    public static final boolean SSL = true;

    // Http Headers
    public static final String DEPRECATED = "x-kassq-sg-deprecated";
    public static final String DATE = "x-kassq-sg-date";
    @Deprecated
    public static final String DATE_YITU = "x-yitu-sg-date";


    public static final String SESSION_ID = "x-kassq-sg-sessionid";

    public static final String USERNAME = "x-kassq-sg-username";
    public static final String PASSWORD = "x-kassq-sg-password";
    @Deprecated
    public static final String USERNAME_YITU = "x-yitu-sg-username";
    @Deprecated
    public static final String PASSWORD_YITU = "x-yitu-sg-password";

    public static final String HTTP2_SCHEME = "x-http2-scheme";


    public static final String VERSION = "x-kassq-sg-version";
    @Deprecated
    public static final String VERSION_YITU = "x-yitu-sg-version";


    public static final String REQUEST = "x-kassq-sg-requst";
    public static final String FACE_VX = "face_vx";
    public static final String INCLUDE_PICTURE = "include_picture";
    public static final int UPDATE_REPO_BATCH_SIZE = 1;
    public static final String SG_SCHEMA = "x-kassq-sg-schema";
    // Http接收的消息类型
    public static final String AVRO = "application/avro";
    public static final String JSON = "application/json";

    // Http接口版本
    public static final String VERSION_NO = "V1.0";
    public static final String FACE_V2 = "face_v2";

    public static final int GET_RECORD_TIMEOUT = 1000 * 30; // 获取日志接口超时时长，单位ms

    public static final int IDEL_TIMEOUT_SECONDS = 5;
    public static final int PING_TIMEOUT_SECONDS = IDEL_TIMEOUT_SECONDS * 4; //应该大于2倍，4倍是为了保险；副作用是真断线了延时会长，根据实际情况调整

    public static final int PING_PERIOD = 4000;
    public static final int ACTIVE_PING_TIMEOUT = 30 * 1000;
    public static final int PING_PONG_PERIOD = 10; // 设置空闲触发PINGPONG时长， 单位s

    public static final String WAIT_SUCCESS = "WAIT_SUCCESS";
    public static final String WAIT_HTTP_EXCEPTION = "WAIT_HTTP_EXCEPTION";
    public static final String WAIT_INTERRUPT = "WAIT_INTERRUPT";
    public static final String WAIT_TIMEOUT_EXCEPTION = "WAIT_TIMEOUT_EXCEPTION";
    public static final String WAIT_NETWORK_EXCEPTION = "WAIT_NETWORK_EXCEPTION";
    public static final String WAIT_FORBIDDEN_EXCEPTION = "403";
    public static final String WAIT_UNAUTHORIZED_EXCEPTION = "401";
    public static final String WAIT_BAD_REQUEST_EXCEPTION = "400";
    public static final String WAIT_DEVICE_INTERNAL_ERROR = "500";
    public static final String WAIT_DEVICE_EXCEPTION = "WAIT_DEVICE_CHECKPOINT_EXCEPTION";

}
