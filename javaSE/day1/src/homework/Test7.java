package homework;

import java.util.Scanner;

public class Test7 {
    /**
     *  什么是素数：一个大于1的自然数，除了1和它本身外，不能被其他自然数整数
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个大于1的自然数");
        int num = input.nextInt();

        if (num <= 1) {
            System.out.println("请输入一个大于1的自然数");
        } else {
            //第一种解法，通过打标记的形式解决
            /*boolean flag = true; //假设这个数是素数
            for (int i = 2; i < num ; i++) {
                if (num % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(num + "是一个素数");
            } else {
                System.out.println(num + "不是素数");
            }*/

            int i = 2;
            for (; i < num ; i++) {
                if (num % i == 0) {
                    break; //如果循环提前结束，i的值必定不等于num
                }
            }
            if (i != num) {//判断循环是否提前结束
                System.out.println(num + "不是素数");
            } else {
                System.out.println(num + "是一个素数");
            }
        }
    }
}
