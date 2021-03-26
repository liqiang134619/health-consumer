package com.dycn.airportconsumer.faceplate;

/**
 * @author Liq
 * @date 2021/1/21
 */
public interface IHttpConnectionManager {


    HttpConnection connectServer(String ip, int port, int timeoutSeconds) throws Exception;

    void disConnectDevice(String ip, int port);

    boolean isChannelActive(String ip, int port);
}
