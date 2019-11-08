package demo2;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.test(new Cat());

        Pet pet = new Cat();//多态，里氏替换原则。
        System.out.println(pet);
        Pet dog = new Dog();

        Pet duck = new Duck();
    }

    void test(Pet pet){
        pet.run();
        pet.shut();
    }
}
