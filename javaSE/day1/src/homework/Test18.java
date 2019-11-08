package homework;

public class Test18 {
    public static void main(String[] args) {
        final int ROW = 6;
        for (int i = 1; i <= ROW; i++) {
            //打印空格
            for (int j = 1; j <= ROW - i ; j++) {
                System.out.print(" ");
            }
            //打印*
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }

            //换行
            System.out.println();
        }
    }
}
