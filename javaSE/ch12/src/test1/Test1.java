package test1;

import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) {

        MyThread1 t1 = new MyThread1(); //第一个线程,只输出偶数
        MyThread2 t2 = new MyThread2(); //第二个线程，只输出奇数

        //通过start方法开启线程
        t1.start(); //每个线程只能开启一次
        t2.start();
    }

    /**
     * 继承自Thread类的子类
     * 通过继承Thread类，能够实现多线程
     * 一个Thread类的对象，称为一个线程
     *
     * 通过重写父类中的run方法实现多线程
     */
    private static class MyThread1 extends Thread{
        @Override
        public void run() {
            int i = 0;
            //实现线程
            while (true) {
                i += 2;
                //获取当前正在执行的线程
                Thread thread = Thread.currentThread();
                String name = thread.getName(); //得到当前线程的名称
                System.out.println(name +  ":" + i);
                try {
                    Thread.sleep(100); //每次执行的时候都使线程休眠100毫秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class MyThread2 extends Thread{
        @Override
        public void run() {
            int i = 1;
            while (true) {
                i+=2;
                //获取当前正在执行的线程
                Thread thread = Thread.currentThread();
                String name = thread.getName(); //得到当前线程的名称
                System.out.println(name +  ":" + i);
                try {
                    //通过TimeUnit使线程休眠100毫秒
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
