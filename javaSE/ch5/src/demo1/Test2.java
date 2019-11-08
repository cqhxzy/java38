package demo1;

public class Test2 {

    private String str;//类的成员变量，属性
    private static String str2 = "abc";//类的属性

    public static void main(String[] args) {
        Dog dog = new Dog();

        Pet pet = new Pet();//pet是什么宠物？
    }

    /**
     * 类的成员（实例）方法
     */
    public void test(){}

    /**
     * 类方法
     */
    public static void test2(){
        System.out.println(str2);
    }
}
