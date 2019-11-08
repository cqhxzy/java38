package demo2;

/**
 * 抽象类
 */
public abstract class Pet {
    public Pet() {
        System.out.println("抽象类Pet中的无参构造方法被执行了");
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

    /**
     * 任何动物都能跑
     */
    public void run(){
        System.out.println( "任何宠物都能跑");
    }

    /**
     * 不同宠物的叫声是不一样的
     */
    public abstract void shut();
}
