package test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ReadProperties {
    public static void main(String[] args) throws IOException {

        //直接写文件名，相对路径，从当前项目的根目录中查找文件
        //File file = new File("my.properties");

        //已/my.properties方式，会在当前项目所在的盘符的根目录中查找文件
        //File file = new File("/my.properties");
        /*System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());*/

        //相对于当前类的路径读取properties配置文件


        //相对于ReadProperties找到项目的根，/代表着编译后的ch11的目录
        //InputStream resourceAsStream = ReadProperties.class.getResourceAsStream("/my.properties");

        //通过类加载器读取配置文件
        ClassLoader classLoader = ReadProperties.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("my.properties");
        InputStreamReader reader = new InputStreamReader(resourceAsStream);

        //通过Properties类读取properties配置文件中的信息
        Properties properties = new Properties();
        //为Properties设置输入流
        properties.load(reader);

        //根据键，从配置文件中读取值
        String name = properties.getProperty("name");
        System.out.println(name);

        String age = properties.getProperty("age");
        Integer int_age = Integer.valueOf(age);
        System.out.println("age:" + int_age);
        String phone = properties.getProperty("phone");
        System.out.println("phone:" + phone);

    }
}
