package com.dycn.airportconsumer.faceplate;

import com.dycn.airportconsumer.faceplate.avro.*;
import com.dycn.airportconsumer.faceplate.common.ConnectionStatus;
import com.dycn.airportconsumer.faceplate.common.HttpDefine;
import com.dycn.airportconsumer.faceplate.common.HttpEventType;
import com.dycn.airportconsumer.faceplate.common.HttpParameters;
import com.dycn.airportconsumer.faceplate.sream.AccessRecordExecutor;
import com.dycn.airportconsumer.faceplate.sream.SyncFuture;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http2.*;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import org.apache.avro.generic.GenericRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.*;

import static com.dycn.airportconsumer.faceplate.common.HttpDefine.*;
import static com.dycn.airportconsumer.faceplate.common.HttpEventType.ACCESS_RECORD;
import static com.dycn.airportconsumer.faceplate.common.HttpParameters.PERSONS;
import static io.netty.handler.codec.http.HttpResponseStatus.*;

/**
 * @author Liq
 * @date 2021/1/23
 */
//@ChannelHandler.Sharable
public class Http2ClientHandler extends DelegatingDecompressorFrameListener {

    private static final Logger mLogger = LoggerFactory.getLogger(Http2ClientHandler.class);

    private ConcurrentMap<Integer, ByteBuf> mConnectionDataMap;

    private IRecordsEventManager.IConnectionStatusEventHandler mConnectionHandler = null;


    //处理事件监听
    private int mAccessRecordId = -1;
    private int mPersonsId = -1;
    private int mRecentRecordId = -1;
    private ChannelHandlerContext mChannelHandlerContext;
    private int mStreamId = 1;


    //相关执行类

    private AccessRecordExecutor mAccessRecordExecutor;
    private PersonRepoExecutor mPersonRepoExecutor;
    private RecentRecordExecutor mRecentRecordExecutor;
    private OperationRecordExecutor mOperationRecordExecutor;


    private WaitRunnable mWaitRunnable;
    private WaitRunnable mAccessWaitRunnable;
    private WaitRunnable mPersonsWaitRunnable;
    private WaitRunnable mSummaryWaitRunnable;
    private WaitRunnable mRecentWaitRunnable;


    //从外面传过来的数据
    private String mHost;
    private int mPort;

    private long mLastPingAckTime = System.currentTimeMillis();

    private ExecutorService mExecutorService = Executors.newFixedThreadPool(1);


    //存数据,key是streamId
    private Map<Integer, byte[]> mDataMap;

    //存请求url,key是streamId
    private Map<Integer, String> mConnectionRequestMap;

    //存Header的状态,key是streamId
    private Map<Integer, CharSequence> mHeaderStatusMap;
    //存Header的状态,key是streamId
    private Map<Integer, CharSequence> mSchemaMap;


    private Map<Integer, SyncFuture> futureMap;

    private int mOperationRecordId = -1;

    private Map<Integer, HttpMethod> mMethodMap;

    private Map<Integer, HttpServletResponse> httpServletRespMap;



    //与连接相关，可以发送rst stream，监控连接状态
    private HttpRequestHandler mHttpRequestHandler;
    private HttpResponseHandler mResponseHandler;


    public Http2ClientHandler(Http2Connection connection, Http2FrameListener listener, String host, int port) {
        super(connection, listener);
        mLogger.info(" 创建了一个新的[ Http2ClientHandler ] Http2ClientHandler: {}", this);

        mHttpRequestHandler = new Http2HandlerBuilder().build();

        this.mHost = host;
        this.mPort = port;


        //初始化各种Map
        mConnectionRequestMap = PlatformDependent.newConcurrentHashMap();
        mHeaderStatusMap = PlatformDependent.newConcurrentHashMap();
        mDataMap = PlatformDependent.newConcurrentHashMap();
        mSchemaMap = PlatformDependent.newConcurrentHashMap();
        futureMap = PlatformDependent.newConcurrentHashMap();

        mResponseHandler = new HttpResponseHandler(this);

        mConnectionDataMap = PlatformDependent.newConcurrentHashMap();


        mPersonRepoExecutor = new PersonRepoExecutor(this);

        mMethodMap = PlatformDependent.newConcurrentHashMap();

        httpServletRespMap = PlatformDependent.newConcurrentHashMap();

    }


    private CountDownLatch waitForConnected = new CountDownLatch(1);


    public void setConnectionHandler(IRecordsEventManager.IConnectionStatusEventHandler connectionStatusEventHandler){
        this.mConnectionHandler = connectionStatusEventHandler;
    }


    /**
     * 订阅过人日志事件
     *
     * @param handler
     */
    public void subscribeAccessRecordEvent(IRecordsEventManager.IRecordEventHandler handler) {
         mAccessRecordExecutor = new AccessRecordExecutor(handler, mHost);
    }


    /**
     * 获取日志
     */
    public void getRecords(String url, String username, String password, String checkpoint, String accessRecordsType, String apiVersion, long fromTimeStamp)
            throws SGHttp2Exceptions.NetworkException, SGHttp2Exceptions.OperationException, SGHttp2Exceptions.DeviceException {
        try {
            waitForConnected.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(url.equals(HttpParameters.FETCH_ACCESS_RECORD)){
            url = url + "&checkpoint=" + checkpoint + "&access_records_type=" + accessRecordsType;
        }else {
            url = url + "&checkpoint=" + checkpoint + "&access_records_type=" + accessRecordsType + "&from_timestamp=" + fromTimeStamp;
        }


        sendGetRequest(mChannelHandlerContext, url, username, password, apiVersion);

        // 启动阻塞线程，等待请求完成
        CompletableFuture waitFuture = new CompletableFuture();
        mAccessWaitRunnable = new WaitRunnable(waitFuture, HttpDefine.GET_RECORD_TIMEOUT);
        Future future = mExecutorService.submit(mAccessWaitRunnable);
        try {
             mLogger.info("===> 开始等待");
            future.get();
            Object waitResult = waitFuture.get();
             mLogger.info("===> 等待结束");
            if (Objects.equals(waitResult, HttpDefine.WAIT_HTTP_EXCEPTION)) {
                throw new SGHttp2Exceptions.OperationException("获取日志失败");
            } else if (Objects.equals(waitResult, HttpDefine.WAIT_DEVICE_EXCEPTION)) {
                throw new SGHttp2Exceptions.DeviceException("获取日志失败，checkpoint异常");
            }
            mLogger.info("getRecords waitFuture.get(): {}", waitResult);
        } catch (InterruptedException | ExecutionException e) {
            mLogger.error("getRecords Exception: {}", e.getMessage());
        }
    }




    /**
     * 下发人像库.
     */
    // 同步线程
    private Semaphore mUpdateRepoSettingsSemaphore = new Semaphore(1);


//    public void updateRepoSettings(String url, String username, String password, int repoSize, OperationType operationType,
//                                   File[] fileArray, String cardNo) throws Exception {
//        for (int i = 0; i < fileArray.length; i += UPDATE_REPO_BATCH_SIZE) {
//
//            File[] filesBatch = Arrays.copyOfRange(fileArray, i, Math.min(fileArray.length, i + UPDATE_REPO_BATCH_SIZE));
//            List<GenericRecord> operations = UpdateRepo.buildOperationList(operationType, filesBatch, cardNo);
//
//            ByteBuf content = AvroUtil.encode(Operation.getClassSchema(), operations);
//            // 3秒钟获取不到锁
//            if (!mUpdateRepoSettingsSemaphore.tryAcquire(3, TimeUnit.SECONDS)) {
//                int i1 = mUpdateRepoSettingsSemaphore.availablePermits();
//                mLogger.info("========availablePermits==========> 获取不到信号：{}",i1);
//                mLogger.info("========重新建立信号量==========> ");
//                mUpdateRepoSettingsSemaphore = new Semaphore(1);
//                mUpdateRepoSettingsSemaphore.acquire();
//            } else {
//                mUpdateRepoSettingsSemaphore.acquire();
//
//            }
//            mLogger.info(i/UPDATE_REPO_BATCH_SIZE + " batch");
//            sendPostRequest(mChannelHandlerContext, content, url, username, password);
//            content.release();
//        }
//    }

    public void updateRepoSettings(String url, String username, String password, int repoSize, OperationType operationType, InputStream inputStream, String name, String cardNo) throws Exception {
        List<GenericRecord> operations = UpdateRepo.buildOperationList(operationType, inputStream, cardNo, name);
        ByteBuf content = AvroUtil.encode(Operation.getClassSchema(), operations);
//        int availablePermits = mUpdateRepoSettingsSemaphore.availablePermits();
//        mLogger.info("=========availablePermits:{}=====",availablePermits);
//        mUpdateRepoSettingsSemaphore.acquire();
        // tryAcquire 会获取一个信号量的
        if (!mUpdateRepoSettingsSemaphore.tryAcquire(5, TimeUnit.SECONDS)) {
            mLogger.info("========重新建立信号量==========> ");
            mUpdateRepoSettingsSemaphore = new Semaphore(1);
            mUpdateRepoSettingsSemaphore.acquire();
        }
        // 3秒钟获取不到锁
//        int queueLength = mUpdateRepoSettingsSemaphore.getQueueLength();
//        mLogger.info("========queueLength==========> {}",queueLength);
//
//
//        if (!mUpdateRepoSettingsSemaphore.tryAcquire(3, TimeUnit.SECONDS)) {
//            int i1 = mUpdateRepoSettingsSemaphore.availablePermits();
//            mLogger.info("========availablePermits==========> 获取不到信号：{}",i1);
//            mLogger.info("========重新建立信号量==========> ");
//            mUpdateRepoSettingsSemaphore = new Semaphore(1);
//            mUpdateRepoSettingsSemaphore.acquire();
//        } else {
//            mUpdateRepoSettingsSemaphore.acquire();
//
//        }
        sendPostRequest(mChannelHandlerContext, content, url, username, password);
        content.release();

    }


    public void updateRepoSettings(String url, String username, String password, OperationType operationType, List<String> list) throws  Exception {
        List<GenericRecord> operations = UpdateRepo.buildOperationList(operationType, list);
        ByteBuf content = AvroUtil.encode(Operation.getClassSchema(), operations);
//        if (!mUpdateRepoSettingsSemaphore.tryAcquire(5, TimeUnit.SECONDS)) {
//            mLogger.info("========重新建立信号量==========> ");
//            mUpdateRepoSettingsSemaphore = new Semaphore(1);
//            mUpdateRepoSettingsSemaphore.acquire();
//        }
        sendPostRequest(mChannelHandlerContext, content, url, username, password);
        content.release();
    }



    /**
     * Sends a post request to the server.
     */
    public void sendPostRequest(ChannelHandlerContext ctx, ByteBuf payload, String url, String username, String password) throws SGHttp2Exceptions.NetworkException {
        if (mChannelHandlerContext == null || !mChannelHandlerContext.channel().isActive()) {
            throw new SGHttp2Exceptions().new NetworkException();
        }
        HttpAvroRequest avroRequest = new HttpAvroRequest(mHost, mPort, url, payload, HttpMethod.POST, username, password);
        sendRequest(avroRequest, ctx.newPromise(), url);
    }










    /**
     * 收到一个frame回调.
     */
    @Override
    public int onDataRead(ChannelHandlerContext ctx, int streamId, ByteBuf data, int padding, boolean endOfStream) throws Http2Exception {
        mLastPingAckTime = System.currentTimeMillis();
        String requestUrl = mConnectionRequestMap.get(streamId);
        // mLogger.info("[ Receive Data Frame ] streamId: {}, host: {}, requestUrl: {}", streamId, mHost, requestUrl);

        ByteBuf payload = mConnectionDataMap.get(streamId);

        if (payload != null) {
            payload = Unpooled.copiedBuffer(payload, data);
        } else {
            payload = Unpooled.copiedBuffer(data);
        }

        // 200
        if (Objects.equals(mHeaderStatusMap.get(streamId), OK.codeAsText())) {
            if (requestUrl != null) {
                if (requestUrl.startsWith(HttpParameters.ACCESS_RECORD) || requestUrl.startsWith(HttpParameters.FETCH_ACCESS_RECORD)) {

                    boolean isFetchApi =  requestUrl.startsWith(HttpParameters.FETCH_ACCESS_RECORD);
                    mAccessRecordId = streamId;
                    String schemaString = mSchemaMap.get(streamId).toString();

                    try {
                        mAccessRecordExecutor.processAccessRecord(payload, schemaString, isFetchApi);
                        // mLogger.info("[ Receive Access Data Frame ] Host: {} Put into queue", mHost);
                    } catch (Exception e) {
                        mLogger.error("Exception while processAcessRecord : {}", e.getMessage());
                    }
                    return super.onDataRead(ctx, streamId, data, padding, endOfStream);




                } else if (requestUrl.startsWith(HttpParameters.RECENT_RECORD)) {

                } else if (requestUrl.startsWith(HttpParameters.OPERATION_RECORD_STREAM)) {

                } else if (requestUrl.startsWith(HttpParameters.BACKUP_SETTINGS)) {

                } else if (requestUrl.startsWith(HttpParameters.OPERATION_RECORD_BATCH)) {

                } else {
                    mConnectionDataMap.put(streamId, payload);
                    if (!endOfStream) {
                        mLogger.info("endof stream false;");
                        return data.readableBytes() + padding;
                    }
                }
                try {
                    int contentLength = payload.readableBytes();
                    byte[] rawDataInBytes = new byte[contentLength];
                    int index = payload.readerIndex();
                    payload.getBytes(index, rawDataInBytes);
                    switch (requestUrl) {
                        case HttpParameters.PERSONS_VERSION:
                            break;
                        case HttpParameters.PERSONS_DETAIL:
                            break;
                        case PERSONS:
                                mPersonRepoExecutor.handleSingPersonQuery(ctx, streamId, rawDataInBytes);
                            break;
                        case HttpParameters.DEVICE:
                            break;
                        case HttpParameters.REMOTE_DOOR_CONTROL:
                            break;
                        case HttpParameters.SETTINGS:
                            GeneralResponseExecutor.handleResponse(ctx, streamId, HttpDeviceInfo.getClassSchema(), rawDataInBytes);
                            break;
                        default:
                            if (requestUrl.contains(PERSONS)) {
                                SyncFuture syncFuture = futureMap.get(streamId);
                                List<GenericRecord> records = new ArrayList<>();
                                if (rawDataInBytes != null) {
                                    records = AvroUtil.decode(Person.getClassSchema(), rawDataInBytes);
                                    if (records != null && records.size() > 0) {
                                        Person person = (Person) records.get(0);
                                        syncFuture.setResponse(person.getId());
                                    } else {
                                        // 空字符
                                        syncFuture.setResponse("");
                                    }
                                }
                            }
                            break;
                    }

                } catch (Exception e) {
                    mLogger.error("onDataRead Exception: {}, streamId: {}", e.getStackTrace(), streamId);
                    mHttpRequestHandler.resetStream(ctx, streamId);

                }

            }
            // 207
        } else if (Objects.equals(mHeaderStatusMap.get(streamId), MULTI_STATUS.codeAsText())) {
            if (requestUrl != null) {
                ResponseMessage responseMessage = new ResponseMessage();
                try {
                    int contentLength = payload.readableBytes();
                    byte[] rawDataInBytes = new byte[contentLength];
                    int index = payload.readerIndex();
                    payload.getBytes(index, rawDataInBytes);
                    List<GenericRecord> newRecords = AvroUtil.decode(responseMessage.getSchema(), rawDataInBytes);
                    mLogger.info("[ Receive Data Frame 207] host: {}, response: {}", mHost, newRecords);
                } catch (Exception e) {
                    mLogger.error("onDataRead Exception: {}, streamId: {}", e.getStackTrace(), streamId);
                    mHttpRequestHandler.resetStream(ctx, streamId);
                }
            }
        } else {
            // error
            // 接收error Message
            ErrorMessage message = new ErrorMessage();

            try {
                SyncFuture syncFuture = futureMap.get(streamId);
                if(syncFuture != null) {
                    syncFuture.setResponse("");
                }
                int contentLength = payload.readableBytes();
                byte[] rawDataInBytes = new byte[contentLength];
                // 当前读索引
                int index = payload.readerIndex();
                // 读取到 rawDataInBytes
                payload.getBytes(index, rawDataInBytes);

                // 使用AVRO 序列化 TODO
                List<GenericRecord> newRecords = AvroUtil.decode(message.getSchema(), rawDataInBytes);
                mLogger.info("[ Receive Data Frame 208] host: {}, response: {}", mHost, newRecords);
            } catch (Exception e) {
                mLogger.error("getErrorMessage IOException: {}", e.getMessage());

            }
        }


        return super.onDataRead(ctx, streamId, data, padding, endOfStream);


    }



    public void getSettings(String url, String username, String password) throws Exception{
        try {
            waitForConnected.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sendGetRequest(mChannelHandlerContext, url, username, password);
    }


    public void getSettings(String url, String username, String password, HttpServletResponse response) throws Exception{
        try {
            waitForConnected.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sendGetRequest(mChannelHandlerContext, url, username, password,response);
    }

    /**
     * Sends a get request to the server.
     */
    public void sendGetRequest(ChannelHandlerContext ctx, String url, String username, String password) throws SGHttp2Exceptions.NetworkException {
        sendGetRequest(ctx, url, username, password, "1.0");
    }


    /**
     * Sends a get request to the server.
     */
    public void sendGetRequest(ChannelHandlerContext ctx, String url, String username, String password,HttpServletResponse response) throws SGHttp2Exceptions.NetworkException {
        sendGetRequest(ctx, url, username, password, "1.0",response);
    }


    /**
     * Sends a get request to the server.
     */
    public void sendGetRequest(ChannelHandlerContext ctx, String url, String username, String password, String apiVersion) throws SGHttp2Exceptions.NetworkException {
        if (mChannelHandlerContext == null) {
            throw new SGHttp2Exceptions().new NetworkException();
        }

        if (!mChannelHandlerContext.channel().isActive()) {
            mLogger.error("mChannelHandlerContext is inactive: {}", ctx.toString());
            throw new SGHttp2Exceptions().new NetworkException();
        }

        HttpAvroRequest avroRequest = new HttpAvroRequest(mHost, mPort, url, null, HttpMethod.GET, username, password);
        avroRequest.setApiVersion(apiVersion == null ? "1.0" : apiVersion);
        sendRequest(avroRequest, ctx.newPromise(), url);
    }



    private CountDownLatch latch = new CountDownLatch(1);

    public String getSinglePerson(String person_id, String user, String password) throws Exception {
        try {
            waitForConnected.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        SyncFuture<String> syncFuture = new SyncFuture<String>();

        String url = String.format("/persons?person_id=%s", person_id);
        return sendRequest(mChannelHandlerContext.newPromise(), url, syncFuture, user, password, "1.0");
    }



    /**
     * 同步发送.
     */
    public String sendRequest(ChannelPromise promise, String url,SyncFuture<String> future, String username, String password,String apiVersion) throws SGHttp2Exceptions.NetworkException {



        if (mChannelHandlerContext == null) {
            throw new SGHttp2Exceptions().new NetworkException();
        }

        if (!mChannelHandlerContext.channel().isActive()) {
            mLogger.error("mChannelHandlerContext is inactive: {}", mChannelHandlerContext.toString());
            throw new SGHttp2Exceptions().new NetworkException();
        }

        HttpAvroRequest avroRequest = new HttpAvroRequest(mHost, mPort, url, null, HttpMethod.GET, username, password);
        avroRequest.setApiVersion(apiVersion == null ? "1.0" : apiVersion);


        synchronized (this) {
            mStreamId += 2;
            mResponseHandler.put(mStreamId, mChannelHandlerContext.channel().write(avroRequest.getRequest()), promise);
            mConnectionRequestMap.put(mStreamId, url);
             // mLogger.info("[ Send Request ] mStreamId: {}, host: {}, url: {}", mStreamId, mHost, url);
        }
        mMethodMap.put(mStreamId, avroRequest.getRequest().getMethod());
        mChannelHandlerContext.channel().flush();
        mLastPingAckTime = System.currentTimeMillis();
        try {
            futureMap.put(mStreamId, future);
            return future.get(30, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        return null;
    }



    /**
     * Sends a get request to the server.
     */
    public void sendGetRequest(ChannelHandlerContext ctx, String url, String username, String password, String apiVersion,HttpServletResponse response) throws SGHttp2Exceptions.NetworkException {
        if (mChannelHandlerContext == null) {
            throw new SGHttp2Exceptions().new NetworkException();
        }

        if (!mChannelHandlerContext.channel().isActive()) {
            mLogger.error("mChannelHandlerContext is inactive: {}", ctx.toString());
            throw new SGHttp2Exceptions().new NetworkException();
        }

        HttpAvroRequest avroRequest = new HttpAvroRequest(mHost, mPort, url, null, HttpMethod.GET, username, password);
        avroRequest.setApiVersion(apiVersion == null ? "1.0" : apiVersion);
        sendRequest(avroRequest, ctx.newPromise(), url,response);
    }


    @Override
    public void onSettingsAckRead(ChannelHandlerContext ctx) throws Http2Exception{
         mLogger.info("received settings ack");
        waitForConnected.countDown();
        mChannelHandlerContext = ctx;
        super.onSettingsAckRead(ctx);
    }



    /**
     * 真正发送请求的地方.
     */
    public void sendRequest(HttpRequest avroRequest, ChannelPromise promise, String url) {
        synchronized (this) {
            mStreamId += 2;
            mResponseHandler.put(mStreamId, mChannelHandlerContext.channel().write(avroRequest.getRequest()), promise);
            mConnectionRequestMap.put(mStreamId, url);
             // mLogger.info("[ Send Request ] mStreamId: {}, host: {}, url: {}", mStreamId, mHost, url);
        }
        mMethodMap.put(mStreamId, avroRequest.getRequest().getMethod());
        mChannelHandlerContext.channel().flush();
        mLastPingAckTime = System.currentTimeMillis();
    }


    /**
     * 真正发送请求的地方.
     */
    public void sendRequest(HttpRequest avroRequest, ChannelPromise promise, String url,HttpServletResponse response) {
        synchronized (this) {
            mStreamId += 2;
            mResponseHandler.put(mStreamId, mChannelHandlerContext.channel().write(avroRequest.getRequest()), promise);
            mConnectionRequestMap.put(mStreamId, url);
            // mLogger.info("[ Send Request ] mStreamId: {}, host: {}, url: {}", mStreamId, mHost, url);
        }
        httpServletRespMap.put(mStreamId,response);
        mMethodMap.put(mStreamId, avroRequest.getRequest().getMethod());
        mChannelHandlerContext.channel().flush();
        mLastPingAckTime = System.currentTimeMillis();
    }


    @Override
    public void onHeadersRead(ChannelHandlerContext ctx, int streamId, Http2Headers headers, int padding, boolean endStream) throws Http2Exception {
        super.onHeadersRead(ctx, streamId, headers, padding, endStream);
        mChannelHandlerContext = ctx;
        mLastPingAckTime = System.currentTimeMillis();
    }


    @Override
    public void onHeadersRead(ChannelHandlerContext ctx, int streamId, Http2Headers headers, int streamDependency,
                              short weight, boolean exclusive, int padding, boolean endStream) throws Http2Exception {
        super.onHeadersRead(ctx, streamId, headers, streamDependency, weight, exclusive, padding, endStream);
//        if (mChannelHandlerContext == null) {
//            waitForConnected.countDown();
//        }
        mLastPingAckTime = System.currentTimeMillis();
        mChannelHandlerContext = ctx;
        String requestUrl = mConnectionRequestMap.get(streamId);
//        mLogger.info("[ onHeadersRead ] streamId: {}, host: {}, requestUrl: {}, status: {}, ctx is live? {},", streamId, mHost, requestUrl, headers.status(), ctx.channel().isActive());
        mHeaderStatusMap.put(streamId, headers.status());
        if (StringUtil.isNullOrEmpty(requestUrl)) {
            return;
        }

        String apiVersion = String.valueOf(headers.get(VERSION));
        // mLogger.info("version: " + apiVersion);

        String schemaString = String.valueOf(headers.get(SG_SCHEMA));
        // mLogger.info("schema: " + schemaString);
        mSchemaMap.put(streamId, schemaString);

        //  mLogger.info(String.format("onHeadersRead, requesturl:%s, headers:%s", requestUrl, getHeaders(headers, "")));


        // 收到门禁回复OK后再传输下一段人像
        if (requestUrl.contains(HttpParameters.ACCESS_RECORD)) {
            if (Objects.equals(headers.status(), OK.codeAsText())) {
                recvResponseComplete(mAccessWaitRunnable);
            } else if (Objects.equals(headers.status(), BAD_REQUEST.codeAsText())) {
                unsubscribeEvent(ACCESS_RECORD);
                recvDeviceResponseFail(mAccessWaitRunnable, new Exception(String.valueOf(headers.status())));
            } else {
                unsubscribeEvent(ACCESS_RECORD);
                recvResponseFail(mAccessWaitRunnable, new Exception(String.valueOf(headers.status())));
            }
        }


        if (requestUrl.contains(PERSONS)) {
            if(HttpMethod.POST.equals(mMethodMap.get(streamId))){
                //post persons
                mUpdateRepoSettingsSemaphore.release();
            }
            if (Objects.equals(headers.status(), OK.codeAsText())) {
                recvResponseComplete(mPersonsWaitRunnable);
            } else if (Objects.equals(headers.status(), MULTI_STATUS.codeAsText())) {
                recvResponseComplete(mPersonsWaitRunnable);
            } else if (Objects.equals(headers.status(), BAD_REQUEST.codeAsText())) {
                 unsubscribeEvent(HttpEventType.PERSONS);
                recvDeviceResponseFail(mPersonsWaitRunnable, new Exception(String.valueOf(headers.status())));
            } else {
                unsubscribeEvent(HttpEventType.PERSONS);
                recvResponseFail(mPersonsWaitRunnable, new Exception(String.valueOf(headers.status())));
            }
        }




    }



    /**
     * 取消订阅
     */
    public void unsubscribeEvent(HttpEventType type) throws UnsupportedOperationException {
        synchronized (this) {
            mLogger.info("unsubscribeEvent：{}", type);
            switch (type) {
                case ACCESS_RECORD:
                    if (mHttpRequestHandler != null) {
                        mHttpRequestHandler.resetStream(mChannelHandlerContext, mAccessRecordId);
                    }
                    if (mAccessRecordExecutor != null) {
                        mAccessRecordExecutor.terminate(type);
                        mAccessRecordExecutor = null;
                    }
                    break;
                case RECENT_RECORD:
                    if (mHttpRequestHandler != null) {
                        mHttpRequestHandler.resetStream(mChannelHandlerContext, mRecentRecordId);
                    }
                    if (mRecentRecordExecutor != null) {
                        mRecentRecordExecutor.terminate(type);
                        mRecentRecordExecutor = null;
                    }
                    break;
                case PERSONS:
                    if (mHttpRequestHandler != null) {
                        mHttpRequestHandler.resetStream(mChannelHandlerContext, mPersonsId);
                    }
                    break;
                case OPEATION_RECORD:
                    if (mHttpRequestHandler != null) {
                        mHttpRequestHandler.resetStream(mChannelHandlerContext, mOperationRecordId);
                    }
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }



    /**
     * 发出的请求返回失败，将某个阻塞线程停掉
     */
    public void recvResponseFail(WaitRunnable thread, Exception e) {
        if (thread != null) {
            mLogger.info("{} recvResponseFail received response is not OK, {}", mHost, e);
            thread.setException();
        }
    }



    /**
     * 发出的请求返回失败，将某个阻塞线程停掉，这种场景可能是设备被重置
     */
    public void recvDeviceResponseFail(WaitRunnable thread, Exception e) {
        if (thread != null) {
            mLogger.info("{} recvDeviceResponseFail received response is not OK, {}", mHost, e);
            thread.setDeviceException();
        }
    }


    /**
     * 发出的请求返回成功，将某个阻塞线程停掉
     */
    public void recvResponseComplete(WaitRunnable thread) {
        if (thread != null) {
            mLogger.info("{} recvResponseComplete received response is OK", mHost);
            thread.terminate();
        }
    }



    private static String getHeaders(Http2Headers headers, String tag){
        StringBuilder stringBuilder = new StringBuilder(tag);
        for(Iterator<Map.Entry<CharSequence, CharSequence>> iter = headers.iterator(); iter.hasNext(); ){
            Map.Entry<CharSequence, CharSequence> entry = iter.next();
            stringBuilder.append(" key:" + entry.getKey().toString() + " value: " + entry.getValue().toString());
        }
        return stringBuilder.toString();
    }



    @Override
    public void onPingAckRead(ChannelHandlerContext ctx, long data) throws Http2Exception {
        mLogger.debug("onPingAckRead");
        mLastPingAckTime = System.currentTimeMillis();
        super.onPingAckRead(ctx, data);
    }

    /**
     * 取消所有线程
     */
    public void stopAllThread() {
        mLogger.info("stopAllThread, mAccessRecordExecutor {}",
                mAccessRecordExecutor);

        if (mConnectionHandler != null) {
            mConnectionHandler.onConnectionStatusChanged(ConnectionStatus.DISCONNECTED);
        }

        recvResponseFail(mWaitRunnable, new SGHttp2Exceptions().new NetworkException());
        recvResponseFail(mAccessWaitRunnable, new SGHttp2Exceptions().new NetworkException());
        recvResponseFail(mPersonsWaitRunnable, new SGHttp2Exceptions().new NetworkException());
        recvResponseFail(mRecentWaitRunnable, new SGHttp2Exceptions().new NetworkException());
    }


    public void isChannelActive(long time) {
        if ((time - mLastPingAckTime) > PING_TIMEOUT_SECONDS * 1000) {
            mLogger.error("{} Channel is Inactive! Ping消息接收超时", mHost);
            stopAllThread();
            mChannelHandlerContext.channel().close();
            if (mConnectionHandler != null) {
                mConnectionHandler.onConnectionStatusChanged(ConnectionStatus.DISCONNECTED);
            }
        }
    }


}
