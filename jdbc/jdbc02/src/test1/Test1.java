package test1;

import java.sql.*;

public class Test1 {

    //连接数据库的字符串
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/myschool?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    static{
        try {
            Class.forName(DRIVER); //加载驱动，触发Driver类中的注册驱动到DriverManager
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //通过驱动管理类获取连接
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            //SQL语句参数化
            String sql = "insert into student (loginPwd,`name`,gender,bornDate) values (?,?,?,?)";
            //预处理sql语句的对象
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, "123456");
            pstmt.setString(2, "admin");
            pstmt.setString(3, "男");

            Timestamp cur = new Timestamp(new java.util.Date().getTime());
            pstmt.setTimestamp(4, cur);

            //执行sql语句
            int i = pstmt.executeUpdate();//返回数据库受影响的行数
            System.out.println(i > 0 ? "操作成功":"操作失败");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
