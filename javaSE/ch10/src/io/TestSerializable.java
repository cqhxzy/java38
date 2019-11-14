package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestSerializable {
    public static void main(String[] args) throws Exception {
        //write();
        read();
    }

    /**
     * 将对象序列化到文件中
     */
    private static void write() throws Exception{
        Food food1 = new Food("牛肉干", 10);
        Food food2 = new Food("豆腐干", 2);
        Food food3 = new Food("果冻", 5);

        List<Food> list = new ArrayList<>();
        list.add(food1);
        list.add(food2);
        list.add(food3);

        //将集合写到文件中
        OutputStream outputStream = new FileOutputStream("F:/foods.obj");
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);

        oos.writeObject(list);//序列化集合到文件中
        oos.close();

        System.out.println("将集合输出到文件成功");
    }

    /**
     * 将文件中的数据反序列化成java对象
     */
    private static void read() throws Exception{
        InputStream inputStream = new FileInputStream("F:/foods.obj");
        ObjectInputStream ois = new ObjectInputStream(inputStream);

        //反序列化
        Object o = ois.readObject();
        //String name = o.getClass().getName();//获取类型的名称
        //System.out.println(name);
        //将取出来的Object对象转换为对应的类型
        List<Food> list = (List<Food>) o;
        list.stream().forEach(System.out::println);
    }
}
