package homework;

import java.util.Scanner;

public class Test5 {
    /*
    * 重写猜数游戏，随机生成一个0-9的数,请用户猜，给出相应提示(太大，太小，相等)，没有猜中继续猜，猜到为止.
    * */
    public static void main(String[] args) {

        int ran = (int)(Math.random() * 10); /*返回一个0-9的随机数*/

        Scanner input = new Scanner(System.in);
        int num;

        do {
            System.out.println("请输入一个0-9的数");
            num = input.nextInt();
            if (num > ran) {
                System.out.println("太大");
            } else if (num < ran) {
                System.out.println("太小");
            } else {
                System.out.println("恭喜你，答对了");
            }
        } while (num != ran); //只要用户输入的数和随机数不同，就要循环
    }
}
