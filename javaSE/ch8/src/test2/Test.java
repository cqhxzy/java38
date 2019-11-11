package test2;

public class Test {
    public static void main(String[] args) {
        //通过单例模式，获取Singleton类的对象
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton1);

        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton2);
    }
}
