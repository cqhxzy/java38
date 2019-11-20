package test2;

public class Test {
    public static void main(String[] args) {
        Repo repo = new Repo();
        Productor productor = new Productor(repo);//生产者

        Consumer c1 = new Consumer(repo);//消费者
        Consumer c2 = new Consumer(repo);

        //开启线程
        Thread thread = new Thread(productor, "张师傅");
        Thread thread1 = new Thread(c1, "小王");
        Thread thread2 = new Thread(c2, "小李");

        //进入可执行状态
        thread.start();
        thread1.start();
        thread2.start();

    }
}
