package test2;

/**
 * 单例模式
 * 单例模式只能产生一个对象
 */
public class Singleton {
    //构造函数私有化
    private Singleton(){

    }

    //创建一个静态的私有的本类的对象
    private static Singleton singleton = new Singleton(); //饿汉式，立即加载

    //对外提供静态的公共的方法获取本类的实例
    public static Singleton getInstance() {
        return singleton;
    }
}
