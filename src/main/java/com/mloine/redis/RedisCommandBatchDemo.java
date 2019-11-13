package com.mloine.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.util.List;

/**
 *  @Author: XueYongKang
 *  @Description:    redis 批量命令例子
 *     1.redis 弱事物 不支持回滚 了解即可
 *     2.pipelined 管道，只建立一次连接避免指令多次建立连接·提高效率
 *  @Data: 2019/11/12 17:43
 */
public class RedisCommandBatchDemo {

    public static void main(String[] args) {

        JedisPool jedispool = RedisDemo.getJedispool();
        Jedis jedis = jedispool.getResource();
        Pipeline pipelined = jedis.pipelined();
        //开启事物
        Response<String> multi = pipelined.multi();

        pipelined.set("xue1","xue1");
        pipelined.hset("persion","name","xueyongkang");
        pipelined.hset("persion","age","18");
        pipelined.hset("persion","sex","male");

        //提交事物
        Response<List<Object>> exec = pipelined.exec();

        pipelined.sync();
        jedis.close();
        List<Object> objects = exec.get();
        objects.stream().forEach(System.out::println);
        objects.stream().forEach(System.out::println);

    }

    /**
     * 不使用pipelined
     * 288
     * @param keys
     */
    public static void delNoStus(String...keys){
        Jedis jedis = new Jedis(RedisDemo.ip,RedisDemo.port);
        for(String key:keys){
            jedis.del(key);
        }
        jedis.close();
    }

    /**
     * 使用pipelined
     * 22
     * 本地测试时间缩短10倍左右!
     * 多次执行命令 应放置重复建立连接 任何工具读应该避免重复连接
     * @param keys
     */
    public static void delNoPipe(String...keys){
        Jedis jedis = new Jedis(RedisDemo.ip,RedisDemo.port);
        Pipeline pipelined = jedis.pipelined();
        for(String key:keys){
            pipelined.del(key);//redis?
        }
        pipelined.sync();//
        jedis.close();
    }
}
