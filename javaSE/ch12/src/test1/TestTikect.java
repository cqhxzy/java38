package test1;

public class TestTikect {
    //main方法实际上就是一个线程
    //在main方法中开启的线程称为main方法的子线程
    //所有的子线程执行完毕后，主线程执行完毕
    static int ticket = 20; //总共有20张票
    public static void main(String[] args) {

        //开启一个子线程，模拟售票点
        Thread thread1 = new Thread(new Ticket());
        Thread thread2 = new Thread(new Ticket());
        Thread thread3 = new Thread(new Ticket());
        Thread thread4 = new Thread(new Ticket());

        //开启线程
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }

    /**
     * 模拟售票
     */
    private static class Ticket implements Runnable {
        @Override
        public void run() {
            while (ticket > 0) {
                String name = Thread.currentThread().getName();
                System.out.println(name + "卖出了第" + ticket + " 张票");
                ticket--;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
