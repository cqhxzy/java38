package io;

import java.io.Serializable;

/**
 * 实现序列化的第一步是让被序列化的对象对应的类
 * 实现序列化接口
 */
public class Food implements Serializable {
    private String name;
    private double price;

    @Override
    public String toString() {
        return "io.Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
