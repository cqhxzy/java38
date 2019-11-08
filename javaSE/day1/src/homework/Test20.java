package homework;

public class Test20 {
    public static void main(String[] args) {
        int a = 1; //假设a为分子
        int b = 1; //b为分母
        for (int i = 0; i < 20; i++) {
            b = a + b; // 3
            a = b - a; // 2
            System.out.print(a + "/" + b + ",");
        }
    }
}
