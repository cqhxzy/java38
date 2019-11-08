package demo1;

public class Dog extends Pet{

    private static String str = "DOG";

    static{
        System.out.println(str);
        System.out.println("Dog类的静态代码块被执行");
    }

    {
        //实例代码块,在实例化Dog类的对象时被执行
        System.out.println("执行Dog类的实例代码块");
    }

    public Dog() {
        super();//调用父类中的无参构造方法
        System.out.println("调用Dog类的无参构造方法");
    }

    public Dog(String nickName, String category, char gender, int age){
        //显式调用父类中的有参构造方法
        super(nickName,category,gender,age);
    }
    /**
     * 狗具有看家的方法
     */
    public void watchDoor(){}
}
