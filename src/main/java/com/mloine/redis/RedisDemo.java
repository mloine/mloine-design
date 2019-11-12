package com.mloine.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 *  @Author: XueYongKang
 *  @Description:    redis 连接例子
 *  @Data: 2019/11/12 17:43
 */
public class RedisDemo {

    private String ip = "127.0.0.1";
    private int port = 6379;
    private String auth = "12345678";

    public JedisPool getJedispool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(500);
        jedisPoolConfig.setMaxIdle(5);
        jedisPoolConfig.setMaxWaitMillis(100);
        jedisPoolConfig.setTestOnBorrow(true);
//       return new JedisPool(jedisPoolConfig,this.ip,this.port,100000,this.auth);
       return new JedisPool(jedisPoolConfig,this.ip,this.port,100000,null);
    }

    public static void main(String[] args) {

        JedisPool jedispool = new RedisDemo().getJedispool();
        Jedis jedis = jedispool.getResource();
        /**
         * key:ey
         * value:
         * NX：设入模式【SET_IF_NOT_EXIST】--仅当key不存在时，本语句的值才设入
         * PX：给key加有效期
         * 1000：有效时间为 1 秒
         */
        String keys = jedis.set("xue","xueValue","NX","PX",1000*30);
        System.out.println(keys);//OK
        String keys1 = jedis.set("xue","xueValue","NX","PX",1000*30);
        System.out.println(keys1);//null

        // ttl xue
        String xue = jedis.get("xue");
        System.out.println(xue);


    }
}
