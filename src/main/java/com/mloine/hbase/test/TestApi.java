package com.mloine.hbase.test;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.Arrays;

/**
 * @Author mloine
 * @Description hbase api 测试
 * @Date 3:02 下午 2020/3/6
 */
public class TestApi {

    final private static String CONFIG_PARAM_QUORUM = "hbase.zookeeper.quorum";
    final private static String HOSTNAME = "vm134";

    private static Connection connection = null;

    private static Admin client = null;

    static{
        try {
            Configuration config = HBaseConfiguration.create();

            config.set(CONFIG_PARAM_QUORUM, HOSTNAME);
            connection = ConnectionFactory.createConnection(config);
            client = connection.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        // 1.测试表是否存在
//        String tableName = "stu5";
//        System.out.printf("表%s是否存在%s\n",tableName,isTableExist(tableName));

        // 2.创建表测试
//        createTable("672898:stu5","info1","info2");
//        System.out.printf("表%s是否存在%s\n",tableName,isTableExist(tableName));


        //3.表删除测试
//        dropTable("stu5");
//        System.out.printf("表%s是否存在%s\n",tableName,isTableExist(tableName));

        //4.创建命名空间测试
//        createNameSpace("672898");

        //5.表添加cell数据
//        putData("stu","1001","info2","name","zhangsan");
//        putData("stu","1001","info2","sex","male");

        //6.获取单行数据
//        getData("stu","1001","","");
//        getData("stu","1001","info1","");
//        getData("stu","1001","info1","name");
        getData("stu2","1001","info","name");

        close();
    }

    /**
     * 关闭资源
     */
    public static void close(){
        if(client != null){
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    //DDL

    /**
     * 1.创建命名空间
     * @param nameSpace  命名空间
     * @throws IOException
     */
    public static void createNameSpace(String nameSpace) {
        try {
            NamespaceDescriptor build = NamespaceDescriptor.create(nameSpace).build();
            client.createNamespace(build);
        }catch (NamespaceExistException e){
            System.out.printf("%s命名空间已存在!",nameSpace);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 1.5 判断表是否存在
     * @param tableName 表名
     * @return
     * @throws IOException
     */
    public static boolean isTableExist(String tableName) throws IOException {

//        // 配置信息
//        // 过时api
////        HBaseConfiguration config = new HBaseConfiguration();
//        Configuration config = HBaseConfiguration.create();
//
//        //对于hbase的客户端，只需要知道hbase所使用的zookeeper集群地址就可以了
//        // 注意hbase只能用域名连接    没有映射就去配置！！！
//        config.set("hbase.zookeeper.quorum", HOSTNAME);
//
//        Connection connection = ConnectionFactory.createConnection(config);
//        Admin hBaseClient = connection.getAdmin();
//        // 过时api
////        HBaseAdmin hBaseClient = new HBaseAdmin(config);

        boolean flag = client.tableExists(TableName.valueOf(tableName));

//        hBaseClient.close();
        return flag;

    }


    /**
     * 2.表创建
     * @param tableName   表名
     * @param columnFamily  列族
     * @return
     * @throws IOException
     */
    public static boolean createTable(String tableName,String... columnFamily) throws IOException {
        if(StringUtils.isEmpty(tableName) || columnFamily.length <= 0){
            System.out.println("参数异常 ");
            return false;
        }
        if(isTableExist(tableName)){
            System.out.printf("表%s已存在!!!\n",tableName);
            return false;
        };
        //创建表描述起
        HTableDescriptor hTableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));
        Arrays.stream(columnFamily).
                forEach((family)->{
                    //列族描述器
                    HColumnDescriptor familyDesc = new HColumnDescriptor(family);
                    //添加列族描述
                    hTableDescriptor.addFamily(familyDesc);
                });

        // 创建表
        client.createTable(hTableDescriptor);

        return true;
    }


    /**
     * 3.表删除
     * @param tableName 表名
     * @return
     * @throws IOException
     */
    public static boolean dropTable(String tableName) throws IOException {
        if(StringUtils.isEmpty(tableName) || !isTableExist(tableName)){
            System.out.println("参数不符合或表不存在!!");
            return false;
        }
        //表下线
        client.disableTable(TableName.valueOf(tableName));
        //表删除
        client.deleteTable(TableName.valueOf(tableName));

        return true;
    }


    //DML
    /**
     * 1.插入数据
     * @param tableName 表名
     * @param rowKey  rowkey
     * @param cf   列族
     * @param cn   列明
     * @param value   值
     * @throws IOException
     */
    public static void putData(String tableName,String rowKey,String cf,String cn,String value) throws IOException {
        // 拿到表
        Table table = connection.getTable(TableName.valueOf(tableName));
        // 创建put对象
        Put put = new Put(Bytes.toBytes(rowKey));
        put.addColumn(Bytes.toBytes(cf),Bytes.toBytes(cn),Bytes.toBytes(value));
        table.put(put);

        //关闭表连接
        table.close();
    }

    //2.查数据get
    public static void getData(String tableName,String rowKey,String cf,String cn) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Get get = new Get(Bytes.toBytes(rowKey));

        //指定获取的列族
        if(StringUtils.isEmpty(cn) && !StringUtils.isEmpty(cf)){
            get.addFamily(Bytes.toBytes(cf));
        }
        if(!StringUtils.isEmpty(cn) && !StringUtils.isEmpty(cf)) {
            get.addColumn(Bytes.toBytes(cf),Bytes.toBytes(cn));
        }

        //设置获取数据的版本数
        get.setMaxVersions(2);

        Result result = table.get(get);

        //解析结果
        Arrays.stream(result.rawCells()).forEach((cell)->{
            String cf1 = Bytes.toString(CellUtil.cloneFamily(cell));
            String cn2 = Bytes.toString(CellUtil.cloneQualifier(cell));
            String value2 = Bytes.toString(CellUtil.cloneValue(cell));
            System.out.printf("CF:%s,\tCN:%s,\tValue:%s\n",cf1,cn2,value2);
        });


    }
    //3.查数据scan

    //4.删除数据


}
