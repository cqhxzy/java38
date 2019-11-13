package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TestWriter {
    public static void main(String[] args) {
        Writer writer = null;
        try {
            writer = new FileWriter("F:/1.txt");

            StringBuilder builder = new StringBuilder()
                    .append("\t\t静夜思\r\n")
                    .append("窗前明月光\r\n")
                    .append("意思地上霜\r\n")
                    .append("举头望明月\r\n")
                    .append("低头思故乡\r\n");
            //直接写字符串
            writer.write(builder.toString());

            /*char[] chars = builder.toString().toCharArray();
            writer.write(chars);*/

            System.out.println("输出文件完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
