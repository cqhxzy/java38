package testList;

import entity.Food;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestLinkedList {
    public static void main(String[] args) {
        //LinkedList实现了List接口
        //LinkedList的实现原理与ArrayList不同，适用场合也不同
        //LinkedList特有的方法能够实现在集合的首尾插入，获取，删除元素
        //LinkedList内部维护的是Node节点的引用，每个Node节点会指向上一个Node的引用以及下一个Node的引用
        //LinkedList在频繁的插入，删除数据时效率比较。但是在遍历以及随机访问的效率比较低
        List<Food> list = new LinkedList<>();//这样写就调用不了LinkedList特有的方法
        list.add(null);

        LinkedList<Food> linkedList = new LinkedList<>();
        list.add(null);

        Food food = new Food("牛肉干", 10.5, 5);
        linkedList.addFirst(food);//向链表集合中的头部插入元素
        linkedList.addLast(null); //向链表集合的尾部插入元素

        linkedList.getFirst(); //获取第一个元素
        linkedList.getLast(); //获取最后一个元素

        boolean contains = linkedList.contains(food);//判断集合中是否包含某个对象

        Food food1 = linkedList.get(0);//获取下标为0的元素

        linkedList.set(0, food);//将对象插入集合中指定的索引处

        linkedList.removeFirst();//删除第一个
        linkedList.removeLast(); //删除最后一个

        linkedList.remove(food); //删除对象
        linkedList.remove(0); //根据下标删除

        linkedList.clear(); //清空集合
        linkedList.isEmpty();//判断集合是否为空

        linkedList.size(); //获取集合中元素的个数



        //遍历LinkedList
        for (int i = 0; i < linkedList.size(); i++) {
            Food food2 = linkedList.get(i);
        }

        //foreach
        for (Food food2 : linkedList) {

        }

        //迭代器
        Iterator<Food> iterator = linkedList.iterator(); //Linked的迭代器
        while (iterator.hasNext()) {
            Food next = iterator.next();
        }

        //通过JDK8的Stream API遍历
        linkedList.stream()    //得到Stream
                    .forEach(t -> System.out.println(t));

        //通过方法引用输出对象
        linkedList.stream().forEach(System.out::println);
    }
}
