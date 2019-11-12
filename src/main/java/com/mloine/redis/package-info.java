package com.mloine.redis;

/**
 *  redis  缓存工具
 *  Redis是一个开源的使用ANSI C语言编写、支持网络、可基于内存亦可持久化的日志型、Key-Value数据库，并提供多种语言的API
 *                      1，Redis安装在磁盘；
 *                      2，Redis数据存储在内存。
 *
 *  1.redis中的数据类型   string hash list set zset
 *      a.string 字符串
 *      b.hash 哈希
 *      c.list 列表
 *      d.set   无序集合
 *      e.zset  有序集合
 *
 *  2.redis的特点
 *      a.速度快
 *      b.键值对的数据结构
 *      c.丰富的功能
 *      d.简单稳定
 *      e.持久化
 *      f.主从复制
 *      g.高可用和分布式转移
 *      h.客户端语言多
 *  3.重要指令
 *    1.查看所有键(生产不推荐) keys *
 *    2.键总数 dbsize
 *    3.键值是否存在 exists key
 *    4.删除键 del key
 *    5.键过期 expire key 10
 *    6.查看剩余过期时间 ttl key
 *    7.查看键的数据类型 type key
 *
 *    set
 *    setnx
 *
 **/
