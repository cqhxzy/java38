package com.wisezone.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Date;
import java.util.*;

public class JdbcUtil {

    private static DataSource dataSource;
    /**
     * 维护的实当前线程的局部变量表
     * 一个用户只有一个线程，在同一个线程中，ThreadLocal相当于是一个针对当前线程的
     * 全局变量表。只要线程没有终止，ThreadLocal中保存的数据就能够被多次获取。
     */
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    private boolean isTransaction = false;//默认没开启事务

    static {
        //注册自定义类，解决日期不能转换的问题
        //数据库查询出的关于日期的类型java.sql.TimeStamp转换为类中需要的java.util.Date
        ConvertUtils.register(new Converter() {
            @Override
            public  Date convert(Class aClass, Object value) {
                if (value != null) {
                    //value的类型为java.sql.timestamp
                    Timestamp db_date = (Timestamp)value;
                    Date date = new Date(db_date.getTime());
                    return date;
                }
                return null;
            }
        },Date.class);//因为数据中的日期类型是java.sql.TimeStamp

        //通过工厂产生一个连接池
        InputStream resourceAsStream = JdbcUtil.class.getResourceAsStream("/jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 建立连接
     *
     * @return
     */
    public Connection getConnection() {
        try {
            //从本地threadLocal种获取连接
            Connection connection1 = threadLocal.get();
            if (connection1 == null) { //第一次获取连接
                System.out.println(Thread.currentThread().getName());
                //向连接池请求一个连接
                Connection connection = dataSource.getConnection();
                threadLocal.set(connection); //将连接保存到当前的threadLocal
                return connection;
            }
            return connection1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭连接，释放资源
     * @param connection
     * @param pstmt
     * @param rs
     */
    public void closeAll(Connection connection, PreparedStatement pstmt, ResultSet rs) {
        try {
            //先关结果集
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (!isTransaction) { //在开启事务的情况下，不需要关闭连接
                if (connection != null) {
                    connection.close();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //负责执行通用的DML操作
    public int executeUpdate(String sql,Object...params){
        Connection connection = this.getConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = initPstmt(connection,sql,params);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(connection,pstmt,null);
        }
        return -1;
    }

    private PreparedStatement initPstmt(Connection connection,String sql,Object...params){
        //预处理sql语句
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            //为sql语句的参数赋值
            if (params != null) { //有参数
                for (int i = 0; i < params.length; i++) {
                    //为i+1位置的问号对应的参数赋值
                    pstmt.setObject(i + 1,params[i]);
                }
            }
            return pstmt;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //负责执行通用的DQL操作
    public <T> List<T> executeQuery(Class<T> tClass,String sql,Object...params){
        Connection connection = this.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<>();
        try {
            pstmt = initPstmt(connection,sql,params);

            rs = pstmt.executeQuery();//执行sql语句，得到结果集

            /**
             * 根据sql语句，得到sql语句的结果集的元数据
             * 元数据中包括内容：sql语句查询的列的个数，sql语句查询的列名
             */
            ResultSetMetaData metaData = rs.getMetaData();
            //获取本次sql语句查询的结果集返回的列的个数
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                //这个for循环代表着当前行的一条数据
                //将这行数据转换为T类型的对象
                //一种约定：T泛型类中的属性必须要和sql语句查询出的列名一致

                //一个空的泛型为T的对象,必须保证T有无参构造函数
                T t = tClass.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    //根据列号获取当前查询的列的列名
                    String columnLabel = metaData.getColumnLabel(i); //studentNo,name,loginPwd,gender,address,phone,bornDate
                    //根据当前列的列号获取该列对应的值
                    Object value = rs.getObject(i);  //1,123456,张三
                    //System.out.println("------列名：" + columnLabel + ",-----值：" + value);

                    //为t对象中的columnLabel对应的属性赋值为value
                    //通过Apache组织中的commons-bean-utils实现
                    //setProperty(对象，属性，值)；为对象的某个属性设置为value
                    //setProperty内部通过java内省机制调用t对象的封装方法为属性赋值
                    BeanUtils.setProperty(t,columnLabel,value);
                }

                //经过columnCount此循环后，t对象的各个属性已经有值了
                //将当前结果集指针指向的这行数据转换为了T对象以后，再插入到集合中
                list.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(connection,pstmt,rs);
        }
        return list;
    }

    /**
     * 将每行数据组件为一个map集合
     * 其中，列作为建，值为列的值
     * @param sql
     * @param params
     * @return
     */
    public List<Map<String,Object>> executeQueryMap(String sql,Object...params){
        Connection connection = this.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Map<String,Object>> list = new ArrayList<>();
        try {
            pstmt = initPstmt(connection,sql,params);

            rs = pstmt.executeQuery();//执行sql语句，得到结果集

            /**
             * 根据sql语句，得到sql语句的结果集的元数据
             * 元数据中包括内容：sql语句查询的列的个数，sql语句查询的列名
             */
            ResultSetMetaData metaData = rs.getMetaData();
            //获取本次sql语句查询的结果集返回的列的个数
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {

                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    //根据列号获取当前查询的列的列名
                    String columnLabel = metaData.getColumnLabel(i); //studentNo,name,loginPwd,gender,address,phone,bornDate
                    //根据当前列的列号获取该列对应的值
                    Object value = rs.getObject(i);  //1,123456,张三

                    row.put(columnLabel,value);
                }

                //经过columnCount此循环后，t对象的各个属性已经有值了
                //将当前结果集指针指向的这行数据转换为了T对象以后，再插入到集合中
                list.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(connection,pstmt,rs);
        }
        return list;
    }

    /**
     * 开启事务
     */
    public void startTransaction(){
        //获取连接
        Connection connection = getConnection();
        try {
            //设置数据库的autocommit为false就可以了
            connection.setAutoCommit(false);
            isTransaction = true; //开启事务
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit(){
        //获取连接
        Connection connection = getConnection();
        try {
            //提交事务
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback(){
        //获取连接
        Connection connection = getConnection();
        try {
            //回滚事务
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭事务操作
     */
    public void endTransaction(){
        //获取连接
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(true);
            isTransaction = false;//关闭事务
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
