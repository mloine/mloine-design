package com.mloine.nio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpServerChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;

import javax.net.ssl.SSLException;
import java.security.cert.CertificateException;

/**
 *  nio netty servers
 *  服务器demo
 *  测试url: http://127.0.0.1:12345/mloine
 */
public class MloineServer {

    private static final int PORT = 12345;//服务端口

    private static EventLoopGroup group = new NioEventLoopGroup();//nio模式 处理和接收连接

    private static ServerBootstrap b = new ServerBootstrap();//服务端启动器

    private static final boolean SSL = false; //安全加密


    public static void main(String[] args) throws SSLException {
        //1.安全加密部分
        final SslContext sslCtx;
        if(SSL){
            SelfSignedCertificate ssc = null;
            try {
                ssc = new SelfSignedCertificate();
            } catch (CertificateException e) {
                e.printStackTrace();
            }
            sslCtx = SslContextBuilder.forServer(ssc.certificate(),ssc.privateKey()).build();
        }else{
            sslCtx = null;
        }

        //2.netty服务端启动
        try{
            b.group(group);//传入处理 和 连接 的线程组
            b.channel(NioServerSocketChannel.class);//指定channel处理连接的模式
            b.childHandler(new MloineServerHandlerInit(sslCtx));//传入管道处理的 handler组
            //绑定端口  监听 阻塞
            ChannelFuture sync = b.bind(PORT).sync();
            System.out.println("服务端启动成功,端口是:"+PORT);

            //监听服务端口关闭监听
            sync.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();//关闭EventLoopGroup,释放掉所有资源包括创建的线程
        }
    }

}
