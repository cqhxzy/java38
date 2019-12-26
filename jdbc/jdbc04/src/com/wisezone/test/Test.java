package com.wisezone.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Test {
    public static void main(String[] args) {
        //test1();

        test2();


    }

    private static void test2() {
        InputStream resourceAsStream = Test.class.getResourceAsStream("/jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
            DruidDataSource dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);


            /*System.out.println("getInitialSize:" + dataSource.getInitialSize()); //获取初始化连接数
            Connection connection = dataSource.getConnection(); //尝试向池中获取一个连接
            System.out.println("getActiveCount:" + dataSource.getActiveCount()); //获取激活的连接数
            System.out.println("getPoolingCount:" + dataSource.getPoolingCount()); //获取池中剩余的连接数
            System.out.println("将"+ connection + "归还连接池。。。。");
            connection.close();//关闭连接
            System.out.println("getPoolingCount:" + dataSource.getPoolingCount()); //获取池中剩余的连接数*/

            ThreadLocal threadLocal = new ThreadLocal();
            Connection connection = dataSource.getConnection(); //尝试向池中获取一个连接
            threadLocal.set(connection); //将连接保存起来

            connection.close();//关闭连接

            System.out.println(connection);

            Object o = threadLocal.get(); //获取保存起来的连接
            System.out.println(o);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 第一种获取Druid连接池对象的方法
     */
    private static void test1() {
        //一个空白的连接池
        DruidDataSource dataSource = new DruidDataSource();
        //设置驱动类
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.24.159:3306/myschool?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        dataSource.setMaxActive(10);
        dataSource.setMinIdle(5);
        dataSource.setInitialSize(5);

        //获取数据库连接
        try {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
