package homework;

import java.util.Scanner;

public class Test9 {
    /**
     * 请用户输入一个正整数，计算这个数字的总和
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数");
        int num = input.nextInt();

        int sum = 0; //用于累加求和
        while (num > 0) {
            int n = num % 10;
            sum += n;

            num /= 10;
        }
        System.out.println("这个数各位累加求和：" + sum);
    }
}
