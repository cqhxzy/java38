package homework;

import java.util.Scanner;

public class Test6 {
    /**
     * 先询问用户需要输入多少个数，之后请用户循环输入这些数，求之中的最大数，和这些数的平均值.
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请问输入多少个数");
        int count = input.nextInt();

        System.out.println("请输入第1个数");
        //假设第一个数是最大的
        int num1 = input.nextInt();
        int max = num1; //假设第一个数就是最大值
        int sum = num1; //累加求和的变量
        for (int i = 2; i <= count ; i++) {
            System.out.println("请输入第" + i + "个数");
            int num = input.nextInt();
            //开始打擂
            if (num > max) {
                max = num;
            }

            //累加求和
            sum += num;
        }
        System.out.println("最大数：" + max + "，平均值：" + sum / count);
    }
}
