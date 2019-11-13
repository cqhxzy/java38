package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TestReader {
    public static void main(String[] args) {
        Reader reader = null;
        try {
            //字符输入流
            reader = new FileReader("F:/武林.txt");
            //每次读一个字符
            // reader.read();

            char[] chars = new char[1024];
            int read;//数组中实际读到的字符的个数
            StringBuilder builder = new StringBuilder();
            while ((read = reader.read(chars)) != -1) {
                builder.append(chars);
            }

            System.out.println(builder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
