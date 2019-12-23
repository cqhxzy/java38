package test1;

import java.sql.*;
import java.text.SimpleDateFormat;

public class Test2 {
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
        //建立和数据库的连接
        Connection connection = null;  //连接数据库的对象
        PreparedStatement preparedStatement = null; //预处理sql语句
        ResultSet resultSet = null; //sql语句查询出的结果集
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "select * from student t where t.gender = ? "; //查询所有的数据
            preparedStatement = connection.prepareStatement(sql);

            //为sql语句设置参数
            preparedStatement.setString(1,"男");

            //直接执行查询操作
            resultSet = preparedStatement.executeQuery();

            System.out.println("学号\t姓名\t密码\t性别\t电话\t地址\t出生日期");
            while (resultSet.next()){ //检测结果集中是否还有下一条数据
                int studentNo = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String loginPwd = resultSet.getString(3);
                String gender = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String address = resultSet.getString(6);
                Timestamp timestamp = resultSet.getTimestamp(7);
                java.util.Date date2 = converTimeStamp2Date(timestamp);
                String date_str = converDate2Str(date2);


                StringBuilder builder = new StringBuilder();

                String s = builder.append(studentNo + "\t")
                        .append(name + "\t")
                        .append(loginPwd + "\t")
                        .append(gender + "\t")
                        .append(phone + "\t")
                        .append(address + "\t")
                        .append(date_str)
                        .toString();
                System.out.println(s);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {  //注意关闭资源的顺序为开启的倒序
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private static java.util.Date converTimeStamp2Date(Timestamp timestamp) {
        if (timestamp != null) {
            return new java.util.Date(timestamp.getTime());
        }
        return null;
    }

    private static java.util.Date converSqlDate2UtilDate(Date date){
        if (date != null) {
            return new java.util.Date(date.getTime());
        }
        return null;
    }

    private static String converDate2Str(java.util.Date date){
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        return format;
    }
}
