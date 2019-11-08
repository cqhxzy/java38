package homework;

public class Test16 {
    public static void main(String[] args) {
        /*
        * 多重循环：外层循环执行一次，内层循环执行一遍
        * */
        for (int i = 1; i <= 9 ; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(j + " * " + i + " = " + i * j + "\t");
            }
            System.out.println(); //换行
        }
    }
}
