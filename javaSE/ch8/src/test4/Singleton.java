package test4;

public class Singleton {
    //私有化构造函数
    private Singleton() {

    }

    static{
        System.out.println("singleton类被加载了");
    }

    /**
     * 对外暴露的方法，用户获取本类的对象
     * @return
     */
    public static Singleton getInstance() {
        return SingletonHandler.singleton;
    }

    /**
     * 静态的私有的内部类
     * 私有的：SingletonHandler这个类只能够在Singleton类中被访问
     * 内部类加上static的目的是当成一个普通类来使用，否则普通的内部类必须
     *  通过外部类的实例.new 内部类
     *          new outer().new inner();
     *  给内部类加上static以后
     *          new inner();
     */
    private static class SingletonHandler{
        static{
            System.out.println("Singleton中的内部类被加载了");
        }

        //在内部类中实例化父类的对象
        private static Singleton singleton = new Singleton();
    }
}
