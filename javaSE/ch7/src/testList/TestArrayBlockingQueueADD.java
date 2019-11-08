package testList;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class TestArrayBlockingQueueADD {
    public static void main(String[] args) {
        //初始化长度为5的有界队列
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        for (int i = 0; i < 10; i++) {
            //addToQueueWithPut(queue,i + 1);
            addToQueueWithOffer(queue,i + 1);
        }
    }

    private static <T> void addToQueueWithPut(BlockingQueue<T> queue,T t){
        try {
            queue.put(t);
            System.out.println("队列新增" + t + "成功");
        } catch (InterruptedException e) {
            //e.printStackTrace();
            System.out.println("新增" + t + "时出现异常");
        }
    }

    private static <T> void addToQueueWithOffer(BlockingQueue<T> queue,T t){
        try {
            boolean offer = queue.offer(t, 3, TimeUnit.SECONDS);
            String str = "队列新增" + t;
            System.out.println(offer?str + "成功":str + "失败");
        } catch (InterruptedException e) {
            System.out.println("新增" + t + "时出现异常");
            e.printStackTrace();
        }
    }
}
