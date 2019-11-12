package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestInputStream {
    public static void main(String[] args) {
        try {
            InputStream input = new FileInputStream("F:/武林.txt");

            //readAbyte(input);
            readAarray(input);
        } catch (FileNotFoundException e) { //文件未找到的异常
            e.printStackTrace();
        }
    }

    /**
     * 每次读一个字节
     * @param inputStream
     */
    private static void readAbyte(InputStream inputStream){
        try {
            int i;
            //read方法是一个阻塞的方法，每次返回一个字节，值的范围是0-255，如果到达
            //流的末尾，则返回-1
            StringBuilder builder = new StringBuilder();
            while(  (i = inputStream.read()) != -1  ){
                char c = (char) i;
                builder.append(c);
            }
            System.out.println(builder.toString());
        } catch (IOException e) {//在读文件的过程中出现的异常
            e.printStackTrace();
        } finally {
            try {
                inputStream.close(); //不管程序是否出现异常，最后都需要关闭流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void readAarray(InputStream inputStream) {
        byte[] bytes = new byte[1024];//每次读1024个字节
        int i;

        try {
            //每次读一个指定长度的数组个字节，返回实际读到的字节的个数
            //读到流的末尾时，则返回-1
            StringBuilder builder = new StringBuilder();
            while ( (i = inputStream.read(bytes)) != -1){
                //拼接字符串
                builder.append(new String(bytes, 0, i));
            }
            System.out.println(builder);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();//最后需要关闭流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
