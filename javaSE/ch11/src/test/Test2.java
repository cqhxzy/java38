package test;

import entity.Food;

public class Test2 {
    public static void main(String[] args) {
        Class<Food> foodClass = Food.class;

        //通过反射实例化Food的对象
        try {
            //通过调用Class对应类的无参构造实例化对象
            Food food = foodClass.newInstance();
            System.out.println(food);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
