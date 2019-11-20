package test2;

/**
 * 共享资源，仓库
 */
public class Repo {
    private final int CAPACITY = 100; //假设仓库的容量为100
    private int size = 0; //实际库存

    /**
     * 生产的方法
     */
    public synchronized void produce(){
        String name = Thread.currentThread().getName();
        while (this.size >= CAPACITY){ //库存超出了仓库上限
            try {
                System.out.println("----当前库存" + this.size + "，超出仓库上限，" + name + "等待消费者消费------");
                wait(); //等待消费者消费
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //随机生产一定数量的产品
        int ran = (int)(Math.random() * (CAPACITY - size)) + 1;
        this.size = this.size + ran;
        System.out.println(name + "生产了" + ran + "个产品，库存：《" + this.size + "》");

        notifyAll(); //唤醒其他等待的线程
    }

    public synchronized void sell(){
        String name = Thread.currentThread().getName();
        while (this.size <= 0) {//没有库存
            System.out.println("----当前库存" + this.size + "，不足消费" + name + "等待生产------");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //得到随机消费的数量
        int ran = (int)(Math.random() * this.size) + 1;
        this.size -= ran;
        System.out.println(name + "消费了" + ran + "个产品，当前库存：《" + this.size + "》");

        notifyAll();//唤醒其他线程
    }
}
