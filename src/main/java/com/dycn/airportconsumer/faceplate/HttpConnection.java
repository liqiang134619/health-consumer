package com.dycn.airportconsumer.faceplate;


import com.dycn.airportconsumer.faceplate.common.HttpDefine;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http2.Http2SecurityUtil;
import io.netty.handler.ssl.*;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author Liq
 * @date 2021/1/21
 */
@Slf4j
public class HttpConnection {


    private Channel mChannel;

    private Http2ClientInitializer mInitializer;

    public HttpConnection(EventLoopGroup workerGroup, String host, int port, int timeout) throws Exception {

        // ssl加密
        SslContext sslCtx;

        if(HttpDefine.SSL) {

            // ssl 加密
            SslProvider provider = OpenSsl.isAlpnSupported() ? SslProvider.OPENSSL : SslProvider.JDK;
            sslCtx = SslContextBuilder.forClient()
                    .sslProvider(provider)
                    .ciphers(Http2SecurityUtil.CIPHERS, SupportedCipherSuiteFilter.INSTANCE)
                    .trustManager(InsecureTrustManagerFactory.INSTANCE)
                    .applicationProtocolConfig(new ApplicationProtocolConfig(
                            ApplicationProtocolConfig.Protocol.ALPN,
                            // NO_ADVERTISE is currently the only mode supported by both OpenSsl and JDK providers.
                            ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE,
                            // ACCEPT is currently the only mode supported by both OpenSsl and JDK providers.
                            ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT,
                            ApplicationProtocolNames.HTTP_2,
                            ApplicationProtocolNames.HTTP_1_1))
                    .build();

        } else  {
            sslCtx = null;
        }


        Http2ClientInitializer initializer = new Http2ClientInitializer(sslCtx, Integer.MAX_VALUE, host, port);



        // config the client
        Bootstrap b = new Bootstrap();

        b.group(workerGroup);
        b.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
        b.channel(NioSocketChannel.class);
        b.option(ChannelOption.SO_KEEPALIVE, true);
        //防止数据传输延迟 如果false的话会缓冲数据达到一定量在flush,降低系统网络调用（具体场景）
        b.option(ChannelOption.TCP_NODELAY, true)
                // 容量动态调整的接收缓冲区分配器 以节约内存
                .option(ChannelOption.RCVBUF_ALLOCATOR, AdaptiveRecvByteBufAllocator.DEFAULT)
                // Netty实现了一个Java版的Jemalloc内存管理库 ByteBuf内存池 要搭配ReferenceCountUtil.release(msg);不然造成内存泄漏
                .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
        b.remoteAddress(host,port);
        // 设置initializer
        b.handler(initializer);

        // 异步发起连接

        ChannelFuture channelFuture = b.connect().syncUninterruptibly();
        final Channel channel = channelFuture.channel();
        log.info("【==>netty client Connected to {}：{}】",host,port);

        if (channel == null) {
            throw new IllegalStateException("remoteAddress not set");
        }


        // set constructArgs
        setChannel(channel);
        setInitializer(initializer);

        // Wait for the HTTP/2 upgrade to occur.


        // Wait for the HTTP/2 upgrade to occur.
        Http2SettingsHandler http2SettingsHandler = initializer.settingsHandler();
        http2SettingsHandler.awaitSettings(timeout, TimeUnit.SECONDS);


//        channel.closeFuture().syncUninterruptibly();


    }




    public Channel getChannel() {
        return this.mChannel;
    }

    public void setChannel(Channel mChannel) {
        this.mChannel = mChannel;
    }


    public void disconnect(Channel channel) {
        channel.close().syncUninterruptibly();
    }



    public boolean isChannelActive() {
        return mChannel.isActive();
    }

    public Http2ClientInitializer getInitializer() {
        return mInitializer;
    }

    public void setInitializer(Http2ClientInitializer mInitializer) {
        this.mInitializer = mInitializer;
    }

}
