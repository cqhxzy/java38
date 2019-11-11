package test3;

public class Singleton {
    private Singleton(){}

    private static Singleton singleton = null;//懒汉式

    public static Singleton getInstance() {
        if (singleton == null) {//延迟加载
            singleton = new Singleton();
        }
        return singleton;
    }
}
