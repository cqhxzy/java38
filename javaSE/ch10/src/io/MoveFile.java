package io;

import java.io.*;
import java.util.UUID;

public class MoveFile {
    public static void main(String[] args) {
        String src = "E:/girl.jpg";
        String dest = "F:/20191112";

        move(src,dest);
    }

    /**
     * 将src对应的源文件移动到dest对应的目标目录中
     * @param src
     * @param dest
     */
    private static void move(String src,String dest){
        File file_src = new File(src);
        if (!file_src.exists()) return;

        String newFileName = UUID.randomUUID().toString().replaceAll("-", "");
        String fileName = file_src.getName();//文件的原始名称   girl.jpg
        System.out.println(newFileName);
        int index = fileName.lastIndexOf("."); //得到最后.的位置
        newFileName = newFileName + fileName.substring(index); //在UUID之后拼接后缀名

        File file_dest = new File(dest + "/" + newFileName);
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            //被剪切的文件
            inputStream = new FileInputStream(file_src);
            //接收文件的路径
            outputStream = new FileOutputStream(file_dest);

            byte[] bytes = new byte[1024];
            while (inputStream.read(bytes) != -1){
                //将bytes数组输出到文件
                outputStream.write(bytes);
            }
            System.out.println("复制文件完毕");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
