package test7;

public class Test2 {
    public static void main(String[] args) {

        MyFunctionalInterface2 m1 = (a,b)->{
            System.out.println(a + "+" + b);
            return a + b;
        };
        int add = m1.add(5, 6);
        System.out.println(add);

        //简化过后的写法
        MyFunctionalInterface2 m2 = (x,y) -> x + y;

        int add1 = m2.add(6, 6);
        System.out.println(add1);
    }
}
