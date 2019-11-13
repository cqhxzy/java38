package io;

import java.io.*;

public class TestOutputStreamWriter {
    public static void main(String[] args) throws Exception {
        //字节输出流
        OutputStream outputStream = new FileOutputStream("F:/1.txt",true);

        //将字节输出流转换为字符输出流
        Writer writer = new OutputStreamWriter(outputStream, "UTF-8");

        //通过带缓存的字符输出流保存字符输出流
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        bufferedWriter.newLine();//换行
        bufferedWriter.write("你好");
        bufferedWriter.close();
        System.out.println("输出文件成功");



    }
}
