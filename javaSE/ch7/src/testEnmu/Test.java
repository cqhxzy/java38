package testEnmu;

public class Test {
    public static void main(String[] args) {
        String s = TestEnum1.男.toString();
        //System.out.println(s);

        //System.out.println(TestEnum1.男 instanceof Enum);

        //获取类中的静态常量
        /*String spring = SeasonClass.SPRING;
        String summer = SeasonClass.SUMMER;*/

       /* String name = Season.SPRING.getName();
        System.out.println(name);*/
        int a = Season.SPRING.ordinal();
        int b = Season.SUMMER.ordinal();
        int c = Season.AUTUMN.ordinal();
        int d = Season.WINTER.ordinal();

        //遍历枚举
        Season[] values = Season.values();
        for (Season value : values) {
            String name = value.getName();
            int num = value.getNum();
        }

        int i = Season.SPRING.compareTo(Season.WINTER);
        System.out.println(i);
    }
}
