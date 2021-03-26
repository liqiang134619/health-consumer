/*
 * Copyright 2014 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License, version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.dycn.airportconsumer.faceplate;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http2.HttpConversionUtil;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.PlatformDependent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Process {@link FullHttpResponse} translated from HTTP/2 frames
 */
public class HttpResponseHandler extends SimpleChannelInboundHandler<FullHttpResponse> {
    private static final Logger mLogger = LoggerFactory.getLogger(HttpResponseHandler.class);

    private final Map<Integer, Entry<ChannelFuture, ChannelPromise>> streamidPromiseMap;
    private Http2ClientHandler mHttp2ClientHandler;

    public HttpResponseHandler() {
        // Use a concurrent map because we add and iterate from the main thread (just for the purposes of the example),
        // but Netty also does a get on the map when messages are received in a EventLoop thread.
        streamidPromiseMap = PlatformDependent.newConcurrentHashMap();
    }

    public HttpResponseHandler(Http2ClientHandler clientHandler) {
        // Use a concurrent map because we add and iterate from the main thread (just for the purposes of the example),
        // but Netty also does a get on the map when messages are received in a EventLoop thread.
        streamidPromiseMap = PlatformDependent.newConcurrentHashMap();
        mHttp2ClientHandler = clientHandler;
    }

    /**
     * Create an association between an anticipated response stream id and a {@link ChannelPromise}
     *
     * @param streamId    The stream for which a response is expected
     * @param writeFuture A future that represent the request write operation
     * @param promise     The promise object that will be used to wait/notify events
     * @return The previous object associated with {@code streamId}
     */
    public Entry<ChannelFuture, ChannelPromise> put(int streamId, ChannelFuture writeFuture, ChannelPromise promise) {
        return streamidPromiseMap.put(streamId, new SimpleEntry<ChannelFuture, ChannelPromise>(writeFuture, promise));
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpResponse msg) throws Exception {
        Integer streamId = msg.headers().getInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_ID.text());
        if (streamId == null) {
            mLogger.error("HttpResponseHandler unexpected message received: {}", msg);
            return;
        }

        Entry<ChannelFuture, ChannelPromise> entry = streamidPromiseMap.get(streamId);
        if (entry != null) {
            // Do stuff with the message (for now just print it)
            ByteBuf content = msg.content();
            if (content.isReadable()) {
                int contentLength = content.readableBytes();
                byte[] arr = new byte[contentLength];
                content.readBytes(arr);
                mLogger.info(new String(arr, 0, contentLength, CharsetUtil.UTF_8));
            }

            entry.getValue().setSuccess();
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        mLogger.error("Channel is Inactive!");
        if (mHttp2ClientHandler != null) {
            mHttp2ClientHandler.stopAllThread();
        }
        super.channelInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        mLogger.error("HttpResponseHandler exceptionCaught: {}", cause.getMessage());
        ctx.close();
        if (mHttp2ClientHandler != null) {
            mHttp2ClientHandler.stopAllThread();
        }
    }
}
