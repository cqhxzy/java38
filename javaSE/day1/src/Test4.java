import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        /*
        * 小明为了学好java编程，上午学习理论部分，下午上机编程，老师负责检测是否通过。如果没通过则继续学习，否则通过测试。
        * */
        Scanner input = new Scanner(System.in);
        //声明循环变量
        String answer = null;
        do{
            System.out.println("上午学习理论");
            System.out.println("下午上机编程");
            System.out.println("合格了吗？");

            answer = input.next();
        } while(!answer.equals("y"));//只要没有通过测试，就继续学习

        System.out.println("恭喜你通过了测试！");
    }
}
