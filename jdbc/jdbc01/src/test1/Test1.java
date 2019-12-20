package test1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 通过驱动管理类建立和数据库的连接
 */
public class Test1 {
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

        //通过驱动管理类建立和数据库的连接
        try {
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println(connection != null ? "建立连接成功":"建立连接失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
