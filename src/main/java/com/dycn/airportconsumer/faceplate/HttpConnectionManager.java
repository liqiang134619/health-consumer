package com.dycn.airportconsumer.faceplate;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Liq
 * @date 2021/1/21
 */
@Component
public class HttpConnectionManager implements IHttpConnectionManager {


    /**
     * ip 与连接的对应关系
     */
    private Map<String, HttpConnection> mHttpConnectionMap = new ConcurrentHashMap<String, HttpConnection>();


    /**
     * netty 客户端工作线程组
     */
    private EventLoopGroup mWorkerGroup = new NioEventLoopGroup();


    private HttpConnectionManager() {

    }


    // 单例
    private static class SingletonHolder {
        private static final HttpConnectionManager SINGLETON = new HttpConnectionManager();
    }


    public static HttpConnectionManager getInstance() {
        return SingletonHolder.SINGLETON;
    }


    /**
     * 根据 ip, 端口建立一个连接
     *
     * @param ip
     * @param port
     * @param timeoutSeconds
     * @return
     * @throws Exception
     */
    @Override
    public HttpConnection connectServer(String ip, int port, int timeoutSeconds) throws Exception {
        HttpConnection httpConnection;
        if(mHttpConnectionMap.get(ip) == null || !mHttpConnectionMap.get(ip).isChannelActive()) {

            // 连接
            httpConnection = new HttpConnection(mWorkerGroup, ip, port, timeoutSeconds);
            mHttpConnectionMap.put(ip,httpConnection);

        } else  {
            // 已存在 获取返回
            httpConnection = mHttpConnectionMap.get(ip);
        }


        return httpConnection;
    }

    /**
     * ip + 端口断开连接
     * @param ip
     * @param port
     */
    @Override
    public void disConnectDevice(String ip, int port) {


        HttpConnection httpConnection = mHttpConnectionMap.get(ip);
        if (httpConnection != null && httpConnection.isChannelActive()) {
            httpConnection.disconnect(httpConnection.getChannel());
        }

    }

    /**
     * 获取连接状态
     * @param ip
     * @param port
     * @return
     */
    @Override
    public boolean isChannelActive(String ip, int port) {
        HttpConnection httpConnection = mHttpConnectionMap.get(ip);
        if (httpConnection == null || !httpConnection.isChannelActive()) {
            return false;
        } else {
            return true;
        }
    }
}
