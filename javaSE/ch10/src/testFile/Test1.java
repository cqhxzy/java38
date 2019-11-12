package testFile;

import java.io.File;
import java.io.IOException;

public class Test1 {
    public static void main(String[] args) {
        /*
        * 一个File的对象代表着一个本地磁盘上的文件或目录
        *
        * 绝对路径：从磁盘根目录定位到文件的路径
        * */

        File f1 = new File("F:"+File.separator+"武林.txt");
        //System.out.println(File.separator);

        System.out.println(f1.exists()); //判断文件或目录是否存在
        System.out.println(f1.getAbsolutePath());//获取f1文件的绝对路径

        File f2 = new File("a.txt");
        //System.out.println(f2.exists());//判断a.txt是否存在
        if (!f2.exists()){ //如果文件不存在则创建该文件
            try {
                f2.createNewFile();
                System.out.println(f2.exists() ? "存在":"不存在");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(f2.getAbsolutePath());

    }
}
