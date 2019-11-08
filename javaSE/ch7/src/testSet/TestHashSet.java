package testSet;

import entity.Food;

import java.util.*;

public class TestHashSet {
    public static void main(String[] args) {
        //test1();
        //test2();
        test3();

    }

    private static void test1() {
        //Set集合
        Set<Integer> set = new HashSet<>();
        set.add(1);
        List<Integer> integers = Arrays.asList(2,3, 4, 5);
        set.addAll(integers); //将另一个集合合并到set集合中

        int size = set.size();//获取集合中元素的个数
        //boolean remove = set.remove(1);//从Set集合中移除某个对象
        //set.clear();   //清空集合中的元素
        boolean contains = set.contains(1); //判断集合中是否包含某个对象
        boolean empty = set.isEmpty();//判断集合是否为空
        Iterator<Integer> iterator = set.iterator(); //迭代器
        while (iterator.hasNext()) {
            Integer next = iterator.next();
        }

        //foreach
        for (Integer integer : set) {
            //System.out.println(integer);
        }

        //Stream
        set.stream().forEach(t -> System.out.println(t));

        boolean add = set.add(1);
        System.out.println(add ? "新增成功":"新增失败");
    }

    private static void test2(){
        Set<Food> set = new HashSet<>();
        set.add(new Food("test1", 0.0, 1));
        set.add(new Food("test2", 0.0, 1));
        set.add(new Food("test3", 0.0, 1));
        set.add(new Food("test4", 0.0, 1));
        set.stream().forEach(t -> System.out.println(t));
    }

    private static void test3(){
        LinkedHashSet<Food> set = new LinkedHashSet<>();
        set.add(new Food("test1", 0.0, 1));
        set.add(new Food("test2", 0.0, 1));
        set.add(new Food("test3", 0.0, 1));
        set.add(new Food("test4", 0.0, 1));
        set.stream().forEach(t -> System.out.println(t));
    }
}
