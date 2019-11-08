package demo2;

public class TestPet {
    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.run();  //父类中的run方法
        dog.shut(); //Dog重写了shut方法，因此调用的Dog自身的shut

        Cat cat = new Cat();
        cat.run(); //父类中的run方法
        cat.shut();//Cat重写了shut，调用的是Cat中的shut方法

        Duck duck = new Duck();
        duck.run();
        duck.shut();
    }
}
