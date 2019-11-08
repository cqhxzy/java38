package test2;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        int[] arr = {1,2,3,4};
        Sheep s1 = new Sheep("alice",3,arr);

        //克隆s1对象
        Sheep clone = s1.clone();

        System.out.println(s1);
        System.out.println(clone);

        System.out.println(s1 == clone);

        s1.getArr()[0] = 111;
        s1.getArr()[1] = 222;

        System.out.println("修改之后");
        System.out.println(s1);
        System.out.println(clone);




    }
}
