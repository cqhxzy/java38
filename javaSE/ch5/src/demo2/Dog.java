package demo2;

/**
 * 狗类，继承自Pet抽象类
 */
public class Dog extends Pet {
    public Dog() {
        super();
        System.out.println("Dog类的无参构造方法被执行了");
    }

    public void watchDoor(){
        System.out.println(super.getNickName() + "看家");
    }

    @Override
    public void shut() {
        System.out.println("狗会汪汪叫");
    }
}
