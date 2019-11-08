package testEnmu;

/**
 * 四季枚举
 */
public enum Season {
    //调用构造函数，初始化一个枚举的实例
    SPRING("春",1),   //多个枚举的实例之间已逗号分隔，最后一个已分号结尾
    SUMMER("夏",2),
    AUTUMN("秋",3),
    WINTER("冬",4);

    private String name;
    private int num;

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    //枚举的构造函数
    Season(String name,int num){
        this.name = name;
        this.num = num;
    }

}
