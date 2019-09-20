package com.mloine.mq.exchange.fanout;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *  @Author: XueYongKang
 *  @Description:    fanout 交换器  广播机子
 *    会广播该交换机下所有的队列
 *  @Data: 2019/9/20 15:02
 */
public class FanoutProducer {

    public final static String  EXCHANGE_NAME = "mloine_fanout_logs";

    public static void main(String[] args) throws IOException, TimeoutException {

        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();

        //默认端口 5672
        connectionFactory.setHost("118.190.215.176");

        //创建连接
        Connection connection = connectionFactory.newConnection();

        //创建信道
        Channel channel = connection.createChannel();

        //在信道中创建交换器  DIRECT交换器 安全匹配
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

        //声明路由
        String[] routekeys = {"mloine","xue","yong","kang"};
        for(int i=0;i<4;i++){
            //路由key
            String routekey = routekeys[i % 4];
            //消息载体
            String msg =  "hello rabbitMq" + (i+1);

            //发布消息
            channel.basicPublish(EXCHANGE_NAME,routekey,null,msg.getBytes());

            System.out.println("Sent:"+routekey+":"+msg);
        }

        //关闭信到
        channel.close();
        //关闭连接
        connection.close();

    }


}
