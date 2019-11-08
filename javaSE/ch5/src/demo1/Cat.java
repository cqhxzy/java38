package demo1;

public class Cat extends Pet{
    public Cat(String nickName, String category, char gender, int age) {
        //通过父类的有参构造函数，为父类中的属性赋值
        super(nickName, category, gender, age);
    }

    /**
     * 猫独有的方法为抓老鼠
     */
    public void catchMouse(){}
}
