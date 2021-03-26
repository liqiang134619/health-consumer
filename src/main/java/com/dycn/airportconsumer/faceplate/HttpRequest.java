package com.dycn.airportconsumer.faceplate;

import com.dycn.airportconsumer.faceplate.common.HttpDefine;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http2.HttpConversionUtil;
import io.netty.util.AsciiString;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static io.netty.handler.codec.http.HttpMethod.POST;
import static io.netty.handler.codec.http.HttpMethod.PUT;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * @author Liq
 * @date 2021/1/23
 */
public class HttpRequest {

    private FullHttpRequest request;
    private Object body;
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";



    public void setApiVersion(String apiVersion) {
        this.request.headers().set(HttpDefine.VERSION, apiVersion);
    }

    public HttpRequest(String host, int port, String url, ByteBuf body, HttpMethod httpMethod, String username, String password) {
        AsciiString hostName = new AsciiString(host + ':' + port);
        FullHttpRequest request = new DefaultFullHttpRequest(HTTP_1_1, httpMethod, url);

        HttpScheme scheme = HttpDefine.SSL ? HttpScheme.HTTPS : HttpScheme.HTTP;
        request.headers().add(HttpHeaderNames.HOST, hostName);
        request.headers().add(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), scheme.name());
        request.headers().add(HttpDefine.HTTP2_SCHEME, scheme.name());


        request.headers().add(HttpDefine.USERNAME, username);
        //仅仅为了兼容老园区
        request.headers().add(HttpDefine.USERNAME_YITU, username);

        request.headers().add(HttpDefine.PASSWORD, password);
        //仅仅为了兼容老园区
        request.headers().add(HttpDefine.PASSWORD_YITU, password);

        request.headers().add(HttpDefine.VERSION, HttpDefine.VERSION_NO);
        //仅仅为了兼容老园区
        request.headers().add(HttpDefine.VERSION_YITU, HttpDefine.VERSION_NO);

        request.headers().add(HttpDefine.FACE_VX, HttpDefine.FACE_V2);
        request.headers().add(HttpDefine.INCLUDE_PICTURE, true);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String time = simpleDateFormat.format(new Date());
        request.headers().add(HttpDefine.DATE, time);

        if (httpMethod.equals(POST) || httpMethod.equals(PUT)) {
            request.content().writeBytes(body);
        }
        this.request = request;
        this.body = body;
    }



    /**
     * @return the request
     */
    public final FullHttpRequest getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public final void setRequest(FullHttpRequest request) {
        this.request = request;
    }

    /**
     * @return the object
     */
    public final Object getBody() {
        return body;
    }

    /**
     * @param body the object to set
     */
    public final void setBody(Object body) {
        this.body = body;
    }


    @Override
    public String toString() {
        return "HttpAvroRequest [request=" + request + ", body =" + body + "]";
    }



}
