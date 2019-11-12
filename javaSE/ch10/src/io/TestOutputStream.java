package io;

import java.io.*;

public class TestOutputStream {
    public static void main(String[] args) {
        String path = "F:/abc.txt";
        File file = new File(path);
        try {
            //OutputStream outputStream = new FileOutputStream(file);
            //OutputStream outputStream = new FileOutputStream(path);   //覆盖原始内容
            //OutputStream outputStream = new FileOutputStream(file,true); //在原始内容之后追加
            OutputStream outputStream = new FileOutputStream(path,false);

            //writeAbyte(outputStream);
            writeabytearray(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 每次写一个字节
     * @param outputStream
     */
    private static void writeAbyte(OutputStream outputStream) {
        String str = "abcdefg你好呀，今天过得怎么样";
        byte[] bytes = str.getBytes(); //将字符串转换成byte数组
        for (byte aByte : bytes) {
            try {
                outputStream.write(aByte); //每次写一个字节
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("写入文件完毕");
        try {
            outputStream.close(); //关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeabytearray(OutputStream outputStream) {
        String str = "abcdefg你好呀，今天过得怎么样";
        byte[] bytes = str.getBytes(); //将字符串转换成byte数组
        try {
            outputStream.write(bytes); //直接将一个byte数组写到文件中
            System.out.println("输出数据到文件完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
