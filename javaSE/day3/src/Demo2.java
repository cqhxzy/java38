import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入年份");
        int year = input.nextInt();
        System.out.println("请输入月份");
        int month = input.nextInt();
        System.out.println("请输入日期");
        int date = input.nextInt();

        int days = date;

        for (int i = 1; i < month ; i++) {
            //每次循环统计每个月所经历的天数
            switch (i){
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                        days += 31;
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        days += 30;
                        break;
                    case 2:
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
                        days+=29;
                    else
                        days += 28;
                    break;
            }
        }
        System.out.println("经历的天数：" + days);
    }
}
