package test1;

public class TestTikect {
    //main方法实际上就是一个线程
    //在main方法中开启的线程称为main方法的子线程
    //所有的子线程执行完毕后，主线程执行完毕
    static int ticket = 20; //总共有20张票
    //4个线程使用了同一个锁
    static Object object = new Object();

    public static void main(String[] args) {

        //开启一个子线程，模拟售票点
        Thread thread1 = new Thread(new Ticket());//线程进入创建状态
        Thread thread2 = new Thread(new Ticket());
        Thread thread3 = new Thread(new Ticket());
        Thread thread4 = new Thread(new Ticket());

        //开启线程
        thread1.start(); //就绪状态，可运行状态
        thread2.start(); //就绪状态，可运行状态
        thread3.start(); //就绪状态，可运行状态
        thread4.start(); //就绪状态，可运行状态

    }

    /**
     * 模拟售票
     */
    private static class Ticket implements Runnable {
        @Override
        public void run() {
            while (ticket > 0) {

                /////////////
                synchronized (object) { //同步代码块。
                    //安全舱门已上锁
                    if (ticket > 0) {
                        String name = Thread.currentThread().getName();
                        System.out.println(name + "卖出了第" + ticket + " 张票");
                        ticket--;
                        //安全舱门已打开
                    }

                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
