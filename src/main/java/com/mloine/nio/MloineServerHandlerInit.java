package com.mloine.nio;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.handler.ssl.SslContext;

/**
 *
 */
public class MloineServerHandlerInit extends ChannelInitializer<SocketChannel> {

    private final SslContext sslContext;

    public MloineServerHandlerInit(SslContext sslContext) {
        this.sslContext = sslContext;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ChannelPipeline pipeline = ch.pipeline();//获取管道

        //处理http服务的handler
        if(sslContext != null){
            pipeline.addLast(sslContext.newHandler(ch.alloc()));
        }
        //httpRep 响应编码
        pipeline.addLast("respEncode",new HttpResponseEncoder());
        //httpReq 请求解码
        pipeline.addLast("reqDecode",new HttpRequestDecoder());

        pipeline.addLast("aggregator",new HttpObjectAggregator(10*1024*1024));

        pipeline.addLast("compresor",new HttpContentCompressor());

        //自己实现的业务
        pipeline.addLast("myHandler",new MyHandler());
    }
}
