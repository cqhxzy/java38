import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入年份");
        int year = input.nextInt();
        System.out.println("请输入月份");
        int month = input.nextInt();
        System.out.println("请输入日期");
        int date = input.nextInt();

        int days = 0;
        switch (month - 1){
            case 11:
                days += 30;
            case 10:
                days += 31;
            case 9:
                days += 30;
            case 8:
                days += 31;
            case 7:
                days += 31;
            case 6:
                days += 30;
            case 5:
                days += 31;
            case 4:
                days += 30;
            case 3:
                days += 31;
            case 2:
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
                    days += 29;
                else
                    days += 28;
            case 1:
                days += 31;
        }

        days += date;
        System.out.println("这一年的第" + days + "天");


    }
}
