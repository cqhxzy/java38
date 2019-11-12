package testFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Test2 {
    public static void main(String[] args) {
        readFileProperty("E:/wx");
    }

    /**
     * 读取文件或目录的属性
     */
    private static void readFileProperty(String path){
        File file = new File(path);
        //判断文件或目录是否存在
        System.out.println("是否存在：" + file.exists());

        //判断File对象是否文件
        System.out.println("是否文件：" + file.isFile());

        //判断File对象是否为目录
        System.out.println("是否目录：" + file.isDirectory());

        //获取文件名
        System.out.println("文件名：" + file.getName());

        //获取绝对路径
        System.out.println("绝对路径：" + file.getAbsolutePath());

        //获取文件的长度，单位为字节
        System.out.println("文件大小：" + file.length());

        //最后一次修改时间
        long l = file.lastModified();
        Date date = new Date(l);
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");

        System.out.println("最后一次修改时间：" + format.format(date));

        //如果file为目录，则获取该目录中的子目录及文件
        if (file.isDirectory()) {
            //获取该目录下的子文件及子目录,返回file对象的数组
            /*File[] files = file.listFiles();
            for (File file1 : files) {
                System.out.println(file1.getName());
            }*/

            //获取该目录下的子文件及子目录的名称
            String[] list = file.list();
            System.out.println(Arrays.toString(list));
        }
    }

    /**
     * 根据路径创建文件，注意，创建目录通过其他方法
     * @param path
     */
    private static void create(String path) {
        File file = new File(path);
        if (!file.exists()){ //没有才创建，有则不创建
            //创建文件
            try {
                boolean newFile = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建目录，注意和创建文件的方法不一样
     * @param path
     */
    private static void mkdir(String path){
        File file = new File(path);
        if (!file.exists()){
            //创建目录
            boolean mkdir = file.mkdir();
        }
    }
}
