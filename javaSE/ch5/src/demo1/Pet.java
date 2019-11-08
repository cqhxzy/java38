package demo1;

public class Pet {
    static{
        System.out.println("Pet类中的静态代码块被执行");
    }

    {
        System.out.println("执行Pet类中的实例代码块");
    }

    public Pet() {
        System.out.println("调用Pet类的无参构造方法");
    }

    public Pet(String nickName, String category, char gender, int age) {
        this.nickName = nickName;
        this.category = category;
        this.gender = gender;
        this.age = age;
    }

    private String nickName;
    private String category;
    private char gender;
    private int age;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void run(){}
    public void shut(){}
}
