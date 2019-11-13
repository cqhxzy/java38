package io;

import java.io.*;

public class TestInputStreamReader {
    public static void main(String[] args) throws Exception {
        //字节输入流
        InputStream inputStream = new FileInputStream("F:/1.txt");
        //将字节输入流转换为字符输入流
        Reader reader = new InputStreamReader(inputStream,"UTF-8");

        //带缓存的字符输入流
        BufferedReader bufferedReader = new BufferedReader(reader);

        String str;
        StringBuilder builder = new StringBuilder();
        while ((str = bufferedReader.readLine()) != null) {
            builder.append(str + "\r\n");
        }

        System.out.println(builder.toString());
        bufferedReader.close();
    }
}
