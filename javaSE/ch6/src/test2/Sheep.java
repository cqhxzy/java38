package test2;

import java.util.Arrays;

public class Sheep implements Cloneable {
    private String name;
    private int age;
    private int[] arr;

    public Sheep(String name, int age,int[] arr) {
        this.name = name;
        this.age = age;
        this.arr = arr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    /**
     * 重写Object类中的clone方法
     */
    @Override
    protected Sheep clone() throws CloneNotSupportedException {
        Sheep clone = (Sheep) super.clone();
        //深克隆
        int[] arr = new int[this.arr.length];
        System.arraycopy(this.arr,0,arr,0,this.arr.length);
        clone.arr = arr;//修改克隆出来的对象的内存地址为新的数组
        return clone;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }
}
