package test2;

public class TestConcurrent {
    public static void main(String[] args) {

        //开启一个线程，用于获取单例模式，并输出内存地址
        for (int i = 0; i < 10; i++) {
            //开了10个线程
            new Thread(()->{
                Singleton instance = Singleton.getInstance();
                System.out.println(instance);
            }).start();
        }



    }
}
