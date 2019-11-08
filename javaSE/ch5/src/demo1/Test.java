package demo1;

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setNickName("泰泰");
        dog.setCategory("泰迪");
        dog.setAge(2);
        dog.setGender('雄');

        dog.run();  //从Pet类中继承的方法
        dog.shut();//从Pet类中继承的方法
        dog.watchDoor(); //Dog类独有的方法

        Cat cat = new Cat("tom","蓝猫",'公',3);
        System.out.println(cat.getNickName());
        System.out.println(cat.getCategory());
        System.out.println(cat.getGender());
        System.out.println(cat.getAge());
    }
}
