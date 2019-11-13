package io;

import java.io.*;

public class TestBufferedReader {
    public static void main(String[] args) {
        Reader reader = null;
        BufferedReader bufferedReader = null;
        try {
            reader = new FileReader("F:/武林.txt");
            //缓存流包装了reader
            bufferedReader = new BufferedReader(reader, 50);

            String str;
            StringBuilder builder = new StringBuilder();
            while ((str = bufferedReader.readLine()) != null) {
                builder.append(str + "\r\n");
            }
            System.out.println(builder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
