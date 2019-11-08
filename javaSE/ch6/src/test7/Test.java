package test7;

public class Test implements MyFunctionalInterface {
    @Override
    public void test() {
        System.out.println("实现接口中的test方法");
    }

    public static void main(String[] args) {
        //接口不能被实例化
        MyFunctionalInterface my = new Test();//多态
        my.test();

        //实例化接口必须重写接口中的所有方法
        //匿名实现的方式实例化接口
        MyFunctionalInterface m1 = new MyFunctionalInterface(){
            @Override
            public void test() {
                System.out.println("匿名实现的test方法");
            }
        };
        m1.test();

        //函数式编程风格，实际上相当于匿名实现
        MyFunctionalInterface m2 = ()-> {
            System.out.println("lambda表达式实现的方法");
        };

        m2.test();
    }
}
