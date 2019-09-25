package com.mloine.jvm;


/**
 *   -- 生成java进程 dump日志    pid
 *   jmap -dump:format=b,file=/home/xxxxx/xxxxxx/dump.out 6588
 *
 *  -- 查看dump日志
 *    jvisualvm 装入dump文件
 *
 * 在应用启动时配置相关的参数 -XX:+HeapDumpOnOutOfMemoryError，当应用抛出OutOfMemoryError时生成dump文件
 *
 */