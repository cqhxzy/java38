package testList;

import entity.Food;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args) {
        test2();
    }

    /**
     * 通过泛型集合为集合中每个元素指定类型
     * 限制集合中保存元素的类型，因此在添加以及获取元素时
     * 集合中元素的类型是明确的，方便使用
     */
    private static void test2(){
        List<Food> foods = new ArrayList<>(); //泛型集合
        //将Food对象插入到集合中
        foods.add(new Food("t1", 1.0, 0));
        foods.add(new Food("t2", 2.0, 0));
        //将Food对象插入到集合下标为0的位置，之前下标为0的元素依次后移
        foods.add(0, new Food("t3", 3.0, 5));
        //修改下标为1的元素
        foods.set(1, new Food("t4", 4.0, 0));

        //获取集合中元素的个数
        int size = foods.size();
        Food food = foods.get(0);//获取集合下标为0的元素
        System.out.println("size:" + size);
        System.out.println("下标为0的食品：" + food);
        System.out.println("下标为1的食品：" + foods.get(1));

        //移除最后一个元素
        foods.remove(foods.size() - 1);
        System.out.println("删除最后一个元素后，剩下元素的个数：" + foods.size());

        System.out.println("\n遍历集合");
        //遍历集合
        for (int i = 0; i < foods.size(); i++) {
            //System.out.println(foods.get(i));
        }

        //通过foreach遍历集合
        for (Food f : foods) {
            //f为集合中每个元素的对象
            //System.out.println(f);
        }

        //通过迭代器遍历集合
        Iterator<Food> iterator = foods.iterator();
        while (iterator.hasNext()) { //移动指针，判断是否还有下一个元素
            Food next = iterator.next();
            //通过迭代器遍历集合时，不能对元素做修改操作
            System.out.println(next);
        }


    }

    /**
     * 通过为没有指定的泛型集合中添加以及获取元素可发现
     * list集合为了能够兼容任何类型，因此它认为集合中的元素类型为Object
     * 在向集合中新增以及获取元素时，其元素的类型是不容易确定的
     * 因此不方便使用
     */
    private static void test1(){
        List list = new ArrayList();  //没有使用泛型
        //没有指定泛型的结合，添加元素的参数类型为Object
        list.add(1);
        list.add("");
        list.add(' ');

        Object o = list.get(0);//没有指定泛型的集合，获取元素的类型为Object
        Integer i = (Integer) o;
        int sum = 5 + i;
        /*Integer i = 0;  //装箱，valueOf()
        int a = 5 + i;  //拆箱，intValue()*/
        System.out.println(o instanceof Integer);

        Object o1 = list.get(1);
        System.out.println(o1 instanceof String);
    }
}
