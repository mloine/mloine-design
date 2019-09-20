package com.mloine.mq.exchange.topic;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *  @Author: XueYongKang
 *  @Description:   消息消费者
 *  @Data: 2019/9/20 15:17
 */
public class Consumer {

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
        channel.exchangeDeclare(TopicProducer.EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

        //声明队列 绑定路由key
        String queueName = channel.queueDeclare().getQueue();
        //channel.queueBind(queueName,TopicProducer.EXCHANGE_NAME,"#.A");
        //channel.queueBind(queueName,TopicProducer.EXCHANGE_NAME,"*.A");
        //channel.queueBind(queueName,TopicProducer.EXCHANGE_NAME,"mloine.*.*");
        channel.queueBind(queueName,TopicProducer.EXCHANGE_NAME,"mloine.*.B");


        System.out.println("waiting for message .......");

        //声明一个消费者  必须有消费者 才能使用消费消息   队列用于存放消息
         DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                String msg = new String(body,"UTF-8");
                System.out.println("Received｛"+envelope.getRoutingKey()+"｝"+msg);
            }
        };


        //消费者 在指定队列上消费  queue-mloine
        channel.basicConsume(queueName,true,defaultConsumer);
    }

}
