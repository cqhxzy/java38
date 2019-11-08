package homework;

import java.util.Scanner;

public class Test17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入三角形的行数");
        int row = input.nextInt();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i ; j++) {
                System.out.print("*");
            }
            System.out.println(); //换行
        }
    }
}
