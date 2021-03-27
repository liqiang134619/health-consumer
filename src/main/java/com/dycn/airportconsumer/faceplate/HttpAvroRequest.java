package com.dycn.airportconsumer.faceplate;

import com.dycn.airportconsumer.faceplate.common.HttpDefine;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;

/**
 * 发起请求类
 * <p>
 * 备注：
 * 发起Avro请求
 */

public class HttpAvroRequest extends HttpRequest {
    public HttpAvroRequest(String host, int port, String url, ByteBuf body, HttpMethod httpMethod, String username, String password) {
        super(host, port, url, body, httpMethod, username, password);
        getRequest().headers().add(HttpHeaderNames.ACCEPT, HttpDefine.AVRO);
    }
}
