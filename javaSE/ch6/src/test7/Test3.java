package test7;

public class Test3 {
    public static void main(String[] args) {
        MyFunctionalInterface3 m = b -> System.out.println(b);
        m.test(10);
        
    }
}
