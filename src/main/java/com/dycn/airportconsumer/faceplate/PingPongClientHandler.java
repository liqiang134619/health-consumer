package com.dycn.airportconsumer.faceplate;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http2.DefaultHttp2FrameWriter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * Client心跳处理类
 */
@ChannelHandler.Sharable
@Slf4j
public class PingPongClientHandler extends SimpleChannelInboundHandler<ByteBuf> {


    private Http2ClientHandler mHttp2ClientHandler;
    private int heartbeatCount = 0;
    public static final int PING_MSG = 1;

    public PingPongClientHandler(Http2ClientHandler http2ClientHandler) {
        this.mHttp2ClientHandler = http2ClientHandler;
    }

    protected void handleAllIdle(ChannelHandlerContext ctx) {
        ByteBuf payload = Unpooled.copiedBuffer(new byte[8]);
        // Should use different payload for each ping.
        payload.setBytes(0, new byte[8]);
        new DefaultHttp2FrameWriter().writePing(ctx, false, PING_MSG, ctx.newPromise());
        ctx.flush();
        if (heartbeatCount > 0) {
            mHttp2ClientHandler.isChannelActive(System.currentTimeMillis());
        }
        // log.info("【==> ping pong :{}】",ctx.channel());
        heartbeatCount++;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {

    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        // IdleStateHandler 所产生的 IdleStateEvent 的处理逻辑.
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            if (e.state() == IdleState.ALL_IDLE) {
                handleAllIdle(ctx);
            }
        }
    }
}
