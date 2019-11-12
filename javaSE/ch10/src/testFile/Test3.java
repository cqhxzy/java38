package testFile;

import java.io.File;

public class Test3 {
    public static void main(String[] args) {
        //removeFile("E:\\wx\\1.txt");
        removeDir("E:/test");
    }

    private static void removeFile(String path){
        File file = new File(path);
        //删除文件，必须保证文件存在及其是一个文件
        if (file.exists() && file.isFile()) {
            boolean delete = file.delete();
            System.out.println(delete ? "删除成功" : "删除失败");
        }
    }

    /**
     * 删除目录
     * 删除目录的前提必须保证目录是空的，如果目录中有子目录或文件
     * 应先删除子目录及文件以后，才能够删除顶级目录
     * @param path
     */
    private static void removeDir(String path) {
        File file = new File(path);
        if (file.exists()){
            if (file.isDirectory()) {
                //递归删除目录及目录中子目录和文件
                removeDir(file);
            } else {
                //文件直接删除
                removeFile(path);
            }
        }
    }

    /**
     * 递归删除目录
     *
     * 外部传递一个File的目录
     * 通过获取这个目录中的子级元素进行遍历
     * 遍历过程中，如果子级元素是文件，则直接删除
     * 如果子级元素是目录，则进入这个目录，继续删除目录的元素
     * 当目录中的元素删除完成后，最后删除为空的目录
     * @param file
     */
    private static void removeDir(File file) {
        if (file.exists()) {
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.isDirectory()) {
                    //如果f为目录，则进入目录

                    //删除前执行的代码
                    removeDir(f);
                    //删除后执行的代码
                } else {
                    f.delete(); //文件直接删除
                }
            }
            file.delete(); //删除空的目录
        }
    }

    //使用递归的方式，计算1-100累加求和
}
