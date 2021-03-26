package com.dycn.airportconsumer.faceplate;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.*;

/**
 * Http请求处理类
 * 备注：每个请求处理类对应一个HttpRequestHandler,获取连接Http2ConnectionHandler，可以主动给对方发stream
 */
public class HttpRequestHandler extends Http2ConnectionHandler implements Http2FrameListener {

    protected HttpRequestHandler(Http2ConnectionDecoder decoder, Http2ConnectionEncoder encoder, Http2Settings initialSettings) {
        super(decoder, encoder, initialSettings);
    }

    /**
     * Sends a resetStream request to the server.
     */
    public void resetStream(ChannelHandlerContext ctx, int streamId) {
        if (streamId > 0) {
            frameWriter().writeRstStream(ctx, streamId, 0, ctx.newPromise());
        }
    }

    /**
     * Sends a sendError request to the server.
     */
    public void sendError(ChannelHandlerContext ctx, int streamId, Http2Headers headers, Exception e) {
        encoder().writeHeaders(ctx, streamId, headers, 0, true, ctx.newPromise());
    }

    @Override
    public int onDataRead(ChannelHandlerContext ctx, int streamId, ByteBuf data, int padding, boolean endOfStream) throws Http2Exception {
        return 0;
    }

    @Override
    public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i1, boolean b) throws Http2Exception {

    }

    @Override
    public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i1, short i2, boolean b, int i3, boolean b1) throws Http2Exception {

    }

    @Override
    public void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i, int i1, short i2, boolean b) throws Http2Exception {

    }

    @Override
    public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i, long l) throws Http2Exception {

    }

    @Override
    public void onSettingsAckRead(ChannelHandlerContext channelHandlerContext) throws Http2Exception {

    }

    @Override
    public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) throws Http2Exception {

    }

    @Override
    public void onPingRead(ChannelHandlerContext channelHandlerContext, long l) throws Http2Exception {

    }

    @Override
    public void onPingAckRead(ChannelHandlerContext channelHandlerContext, long l) throws Http2Exception {

    }

    @Override
    public void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i, int i1, Http2Headers http2Headers, int i2) throws Http2Exception {

    }

    @Override
    public void onGoAwayRead(ChannelHandlerContext channelHandlerContext, int i, long l, ByteBuf byteBuf) throws Http2Exception {

    }

    @Override
    public void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext, int i, int i1) throws Http2Exception {

    }

    @Override
    public void onUnknownFrame(ChannelHandlerContext channelHandlerContext, byte b, int i, Http2Flags http2Flags, ByteBuf byteBuf) throws Http2Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
