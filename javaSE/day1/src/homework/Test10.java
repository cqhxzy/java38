package homework;

import java.util.Scanner;

public class Test10 {
    public static void main(String[] args) {
        /*
        * 请用户输入一个正整数，判断这个数字里面是否包含6
        * */
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个正整数");
        int num = input.nextInt();

        boolean flag = false; //假设不包含6
        while (num > 0) {
            int n = num % 10;
            if (n == 6) {
                flag = true;
                break;
            }

            num /= 10;
        }
        if (flag) {
            System.out.println("包含6");
        } else {
            System.out.println("不包含6");
        }
    }
}
