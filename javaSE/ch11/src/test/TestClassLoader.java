package test;

import entity.Food;

public class TestClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统的类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取扩展的类加载器
        ClassLoader extension = systemClassLoader.getParent();
        System.out.println(extension);

        //获取扩展类加载器的父类
        ClassLoader parent1 = extension.getParent();
        System.out.println(parent1);//获取不到引导类加载器  Bootstrap

        //获取Food类的类加载器
        ClassLoader classLoader = Food.class.getClassLoader();
        System.out.println(classLoader);

        Class<?> aClass = Class.forName("java.lang.Object");
        ClassLoader classLoader1 = aClass.getClassLoader();
        System.out.println(classLoader1);//null,说明Object这个核心类由Bootstrap ClassLoader负责加载
    }
}
