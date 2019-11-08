package homework;

import java.util.Scanner;

public class Test8_1 {
    /**
     * 判断一个正整数是否是回文数
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数");

        int num = input.nextInt();
        int len = 0;
        int temp = num;
        //确定这个数有几位
        while (temp > 0) {
            temp /= 10;
            len++;
        }

        boolean flag = true; //假设这个数是回文数
        for (int i = 0; i < len / 2; i++) {
            //取出低位
            int low = num / (int)Math.pow(10, i) % 10; //求个位
            //取出高位
            int high = num / (int)Math.pow(10, len - 1 - i) % 10;

            if (low != high) {
                flag = false;
                break; //结束循环
            }
        }
        if (flag) {
            System.out.println( num + "是回文数");
        } else {
            System.out.println( num + "不是回文数");
        }
    }
}
