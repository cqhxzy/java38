package test1;

public class Test2 {

    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        //通过start方法开启线程‘
        Thread thread = new Thread(t1); //一个线程

        //匿名实现类
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while (true) {
                    i += 2;
                    String name = Thread.currentThread().getName();
                    System.out.println(name + ":" + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //通过Lambda表达式实现线程
        Thread thread2 = new Thread(()->{
            int i = 1;
            while (true) {
                i += 2;
                String name = Thread.currentThread().getName();
                System.out.println(name + ":" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        thread.start();
        thread1.start();
        thread2.start();
    }

    private static class MyThread1 implements Runnable{

        @Override
        public void run() {
            int i = 0;
            while (true) {
                i += 2;
                String name = Thread.currentThread().getName();
                System.out.println(name + ":" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
