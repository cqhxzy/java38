package test3;

public class Test {
    public static void main(String[] args) {
        //通过单例模式产生唯一的对象
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

    }
}
