package homework;

import java.util.Scanner;

public class Test8 {
    public static void main(String[] args) {
        //提示用户输入一个正整数，求这个数的最高位和最低位
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个正整数");

        //假设：num=123456 / (10^5) % 10 = 1
        //num = 54321 / 10^4 % 10 = 5
        int num = input.nextInt();
        int len = 0;
        int temp = num;
        //确定这个数有几位
        while (temp > 0) {
            temp /= 10;
            len++;
        }
        System.out.println(num + "这个数有" + len + "位");
        /*int result = 1;
        for (int i = 0; i < len - 1; i++) {
            result *= 10;//1*10*10*10*10*10
        }*/
        //求10的N次方
        int result = (int)Math.pow(10, len - 1);

        //System.out.println(result);
        int low = num % 10; //求个位
        int high = num / result % 10;
        System.out.println(num + "最高位：" + high + ",最低位：" + low);

    }
}
