package test;

import entity.Food;

public class TestClass {
    public static void main(String[] args) {
        //有三种方式获取Class的实例

        //通过类名.class获取类的结构
        Class<Food> c1 = Food.class;
        System.out.println(c1.getName());

        //通过对象.getClass方法获取
        //Food food = new Food();
        //Class<? extends Food> c2 = food.getClass();
        //System.out.println(c2.getName());

        //最长用的一种方式
        //通过类的完整路径获取,类的完整路径有包名+类名组成
        try {
            Class<?> c3 = Class.forName("entity.Food");
            System.out.println(c3.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //为什么需要用反射
        /*
        * 现在我们实例化对象通过new 类名方式实例化
        * 直接通过new关键字实例化对象的方式会造成耦合度高的情况
        * spring框架就提出了IOC（控制反转）的概念
        * 说白了，就是我们要使用的对象不由我们自己来new，
        * 由spring框架帮我们去new对象。spring通过DI（依赖注入）的方式为对象中的属性赋值
        * spring框架是不知道我要new什么对象的
        * 因此就有了配置文件的概念。在配置文件配置我们要被new的类的完整路径及name属性
        * spring框架通过注解的方式，在我们需要使用这个类的对象时，自动根据配置文件中配置的路径
        * 实例化对象并注入到我们要用的对象中去。
        * */
    }
}
