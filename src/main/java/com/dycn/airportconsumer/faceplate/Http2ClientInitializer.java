package com.dycn.airportconsumer.faceplate;

import com.dycn.airportconsumer.faceplate.common.HttpDefine;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http2.*;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLException;

/**
 * Configures the netty client pipeline to support HTTP/2 frames.
 *
 * @author Liq
 * @date 2021/1/23
 */
public class Http2ClientInitializer extends ChannelInitializer<Channel> {


    private static final Logger mLogger = LoggerFactory.getLogger(Http2ClientInitializer.class);


    private final SslContext sslCtx;


    private HttpToHttp2ConnectionHandler connectionHandler;

    private HttpResponseHandler responseHandler;
    private Http2SettingsHandler settingsHandler;

    private Http2ClientHandler mHttp2ClientHandler;

    private final int maxContentLength;

    private String mHost = "";
    private int mPort;


    public Http2ClientInitializer(SslContext sslCtx, int maxContentLength, String host, int port) {
        this.sslCtx = sslCtx;
        this.maxContentLength = maxContentLength;
        this.mHost = host;
        this.mPort = port;

    }




    @Override
    protected void initChannel(Channel ch) throws Exception {

        // netty 实现的HTTP2连接的类，false 指定为非服务端
        final Http2Connection connection = new DefaultHttp2Connection(false);

        InboundHttp2ToHttpAdapter listener = new InboundHttp2ToHttpAdapterBuilder(connection).maxContentLength(maxContentLength).propagateSettings(true).build();

        mHttp2ClientHandler = new Http2ClientHandler(connection, listener, mHost, mPort);

        responseHandler = new HttpResponseHandler(mHttp2ClientHandler);

        connectionHandler = new HttpToHttp2ConnectionHandlerBuilder().frameListener(mHttp2ClientHandler).connection(connection).build();

        settingsHandler = new Http2SettingsHandler(ch.newPromise());

        if (HttpDefine.SSL) {
            configureSsl(ch);
        } else {
            configureCleartext(ch);
        }



    }

    private void configureSsl(Channel ch) throws SSLException {
        ChannelPipeline pipeline = ch.pipeline();
        SslContext sslContext = SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE).build();
        pipeline.addFirst(sslContext.newHandler(ch.alloc(), mHost, mPort));
        configureCleartext(ch);
    }


    /**
     * Configure the pipeline for a cleartext upgrade from HTTP to HTTP/2.
     */
    private void configureCleartext(Channel ch) {
        HttpClientCodec sourceCodec = new HttpClientCodec();
        Http2ClientUpgradeCodec upgradeCodec = new Http2ClientUpgradeCodec(connectionHandler);
        HttpClientUpgradeHandler upgradeHandler = new HttpClientUpgradeHandler(sourceCodec, upgradeCodec, 65536);

        // 升级协议
        ch.pipeline().addLast(sourceCodec,
                upgradeHandler,
                new UpgradeRequestHandler(),
                new UserEventLogger());
    }


    protected void configureEndOfPipeline(ChannelPipeline pipeline) {
        pipeline.addLast(settingsHandler);
        // 空闲检测
        pipeline.addLast(new IdleStateHandler(0, 0, HttpDefine.IDEL_TIMEOUT_SECONDS));

        // 心跳
        pipeline.addLast(new PingPongClientHandler(mHttp2ClientHandler));
    }


    /**
     * A handler that triggers the cleartext upgrade to HTTP/2 by sending an initial HTTP request.
     */
    private final class UpgradeRequestHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            DefaultFullHttpRequest upgradeRequest =
                    new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/");
            ctx.writeAndFlush(upgradeRequest);

            ctx.fireChannelActive();

            // Done with this handler, remove it from the pipeline.
            ctx.pipeline().remove(this);

            configureEndOfPipeline(ctx.pipeline());
        }
    }

    /**
     * Class that logs any User Events triggered on this mChannel.
     */
    private static class UserEventLogger extends ChannelInboundHandlerAdapter {
        @Override
        public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
            mLogger.info("User Event Triggered: " + evt);
            // 空闲检测  evt  事件  透传下一个handler
            ctx.fireUserEventTriggered(evt);
        }
    }



    public Http2ClientHandler getHttp2ClientHandler() {
        return mHttp2ClientHandler;
    }



    public Http2SettingsHandler settingsHandler() {
        return settingsHandler;
    }


}
