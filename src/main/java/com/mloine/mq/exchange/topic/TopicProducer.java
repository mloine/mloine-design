package com.mloine.mq.exchange.topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *  @Author: XueYongKang
 *  @Description:    topic 交换器  匹配机制
 *     . 分隔符号
 *     * 匹配一个.的所有信息
 *     # 匹配复数.的所有信息
 *  @Data: 2019/9/20 15:02
 */
public class TopicProducer {

    public final static String  EXCHANGE_NAME = "mloine_topic_logs";

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
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);


        String[] techers={"mloine","xue","yong"};
        for(int i=0;i<3;i++){
            String[]  modules={"kafka","jvm","redis"};
            for(int j=0;j<3;j++){
                String[]  servers={"A","B","C"};
                for(int k=0;k<3;k++){
                    // 发送的消息
                    String message = "Hello Topic_["+i+","+j+","+k+"]";
                    String routeKey = techers[i%3]+"."+modules[j%3]
                            +"."+servers[k%3];
                    channel.basicPublish(EXCHANGE_NAME,routeKey,
                            null, message.getBytes());
                    System.out.println(" [x] Sent '" + routeKey +":'"
                            + message + "'");
                }
            }

        }

        //关闭信到
        channel.close();
        //关闭连接
        connection.close();

    }


}
