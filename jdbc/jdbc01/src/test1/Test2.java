package test1;

import java.sql.*;

/**
 * 预处理SQL语句
 */
public class Test2 {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://192.168.24.128:3306/myschool?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    public static void main(String[] args) {
        //通过类加载器将com.mysql.cj.jdbc.Driver加载到方法区中，触发静态代码块的执行
        try {
            Class.forName(DRIVER); //隐式的注册驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //通过驱动管理类建立和数据库的连接
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            //参数化SQL语句，
            String sql = "insert into student (loginPwd,`name`,gender,bornDate) values (?,?,?,?)";

            //预处理SQL语句
            preparedStatement = connection.prepareStatement(sql);

            //在执行sql语句之前，为SQL语句中的参数赋值
            preparedStatement.setString(1,"admin123"); //参数的索引，索引从1开始
            preparedStatement.setString(2, "nick");
            preparedStatement.setString(3, "男");
            //preparedStatement.setDate(4, new Date(new java.util.Date().getTime()));//当前时间，注意日期为java.sql.Date
            preparedStatement.setTimestamp(4,new Timestamp(new java.util.Date().getTime()));

            //执行sql语句,对数据库做DML操作
            int executeUpdate = preparedStatement.executeUpdate();//该条sql语句对数据库受影响的行数

            System.out.println(executeUpdate > 0 ? "操作成功" : "操作失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { //不管程序是否出现异常，最后都需要释放资源
            //关闭的顺序：开启的倒序
            try {
                if (preparedStatement != null) {
                    preparedStatement.close(); //关闭预处理
                }

                if (connection != null) {
                    connection.close(); //关闭连接
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
