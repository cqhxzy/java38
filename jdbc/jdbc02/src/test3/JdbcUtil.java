package test3;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 一个通用的JDBC连接数据库的工具类
 */
public class JdbcUtil {
    //驱动类
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //连接数据库的URL地址
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/myschool?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    static {
        try {
            Class.forName(DRIVER); //加载并注册驱动类
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //注册自定义类，解决日期不能转换的问题
        //数据库查询出的关于日期的类型java.sql.TimeStamp转换为类中需要的java.util.Date
        ConvertUtils.register(new Converter() {
            @Override
            public  Date convert(Class aClass, Object value) {
                if (value != null) {
                    //value的类型为java.sql.timestamp
                    Timestamp db_date = (java.sql.Timestamp)value;
                    Date date = new Date(db_date.getTime());
                    return date;
                }
                return null;
            }
        },Date.class);//因为数据中的日期类型是java.sql.TimeStamp

    }

    /**
     * 建立连接
     *
     * @return
     */
    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
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
            if (connection != null) {
                connection.close();
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
            //预处理sql语句
            pstmt = connection.prepareStatement(sql);

            //为sql语句的参数赋值
            if (params != null) { //有参数
                for (int i = 0; i < params.length; i++) {
                    //为i+1位置的问号对应的参数赋值
                    pstmt.setObject(i + 1,params[i]);
                }
            }

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(connection,pstmt,null);
        }
        return -1;
    }

    //负责执行通用的DQL操作
    public <T> List<T> executeQuery(Class<T> tClass,String sql,Object...params){
        Connection connection = this.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            if (params != null) {
                //为SQL语句的参数设值
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }

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
}
