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
 *    setn
 *
 *    4.redis.conf 配置文件
 *      config set slowlog-log-slower-than 10000
 *      注意：slowlog-log-slower-than =0记录所有命令 -1命令都不记录
 *
 *      slow-max-len＝10，当有第11条慢查询命令插入时，队列的第一条命令
 *          就会出列，第11条入列到慢查询队列中
 *
 *       slowlog get  慢查询日志获取
 *       slowlog len  慢查询日志长度
 *       slowlog reset   慢查询日志重置
 *
 *    5.redis压测命令
 *    使用redis-benchmark工具
 *
 *       1、redis-benchmark -h 192.168.42.111 -p 6379 -c 100 -n 10000
 *      100个并发连接，10000个请求，检测服务器性能
 *
 *      2、redis-benchmark -h 192.168.42.111 -p 6379 -q -d 100
 *       测试存取大小为100字节的数据包的性能
 *
 *      3、redis-benchmark -h 192.168.42.111 -p 6379 -t set,get -n 100000 -q
 *       只测试 set,lpush操作的性能
 *
 *      4、redis-benchmark -h 192.168.42.111 -p 6379 -n 100000 -q script load "redis.call('set','foo','bar')"
 *      只测试某些数值存取的性能
 *
 *    6.pipeline 多命令组合
 *      pipeline是多条命令的组合，为了保证它的原子性，redis提供了简单的事务，。
 *      redis的简单事务，将一组需要一起执行的命令放到multi和exec两个
 *      命令之间，其中multi代表事务开始，exec代表事务结束
 *      watch命令：使用watch后， multi失效，事务失效
 *      总结：redis提供了简单的事务，不支持事务回滚
 *
 *     7.简单的发布订阅  (不建议使用 请使用专业性更强的mq中间件)
 *      1，发布消息：
 *          publish channel:test "hello world"
 *      2，订阅消息
 *          subscrible channel:test
 *      3，查看订阅数
 *           pubsub numsub channel:test
 *      4，取消订阅
 *           unsubscribe channel:test
 *      5，按模式订阅和取消订阅
 *          psubscribe ch*
 *
 *
 *   8.键的迁移(注意不同服务器上的redis保持版本一致不然有可能报错)
 *      a.dump命令迁移
 *          1,在A服务器上 192.168.42.111
 *              set name james;
 *              dump name;       //  得到"\x00\x05james\b\x001\x82;f\"DhJ"
 *          2,在B服务器上：192.168.42.112
 *              restore name 0 "\x00\x05james\b\x001\x82;f\"DhJ"    //0代表没有过期时间
 *              get name           //返回james
 *      b.migrate 命令迁移
 *          migrate用于在Redis实例间进行数据迁移，实际上migrate命令是将dump、restore、del三个命令进行组合，从而简化了操作流程。
 *
 *          比如：把111上的name键值迁移到112上的redis
 *              192.168.42.111:6379> migrate 192.168.42.112 6379 name 0 1000 copy
 *
 *    9.键的全量便利(生产键值非常多 不建议使用)
 *    keys  * //返回所有的键, *匹配任意字符多个字符
 *    keys *y //以结尾的键，
 *    keys n*e //以n开头以e结尾，返回name
 *    keys n?me  //  ?问号代表只匹配一个字符  返回name,全局匹配
 *    keys n?m*   //返回name
 *    keys [m,l]*  //返回以m l开头的所有键  keys [m]loine 全量匹配mloine
 *    -- 渐进式匹配key 可以限制返回条数  不会阻塞线程 但返回结构 不稳定 捉鸡 - -
 *    scan 0 match n* count 5    ////匹配以n开头的键，最大是取5条，第一次scan 0开始
 **/
