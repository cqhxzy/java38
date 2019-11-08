package testList;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class TestArrayBlockingQueueRemove {
    public static void main(String[] args) {
        List<Character> integers = Arrays.asList('a','b','c','d','e');
        //将list集合转换为阻塞队列
        BlockingQueue<Character> queue = new ArrayBlockingQueue<>(5, true, integers);
        /*BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        //Integer element1 = queue.element();//检索队列的头部，无则抛出异常
        Integer peek = queue.peek(); //检索队列的头部，无则返回null
        System.out.println(peek);*/

        for (int i = 0; i < 10; i++) {
            //take(queue);
            poll(queue);
        }
    }

    /**
     * 队里中无元素可删时，则发生阻塞
     * @param queue
     * @param <T>
     */
    private static <T> void take(BlockingQueue<T> queue){
        try {
            T take = queue.take(); //返回被删除的元素
            System.out.println("队列删除" + take + ",队列剩余元素个数：" + queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 不能向队列中插入null的元素
     * @param queue
     * @param <T>
     */
    private static <T> void poll(BlockingQueue<T> queue){
        try {
            T poll = queue.poll(3, TimeUnit.SECONDS);
            if (Objects.isNull(poll))
                System.out.println("队列已无元素可删");
            else
                System.out.println("队列删除" + poll + "成功");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
