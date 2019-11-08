package homework;

public class Test15 {
    public static void main(String[] args) {
        for (int i = 100; i <= 999; i++) {
            int temp = i;
            int sum = 0;
            while (temp > 0) {
                int n = temp % 10; //取出每一位
                temp /= 10;

                sum += (int)Math.pow(n,3);
            }

            if (sum == i) {
                System.out.println(sum + " ");
            }
        }
    }
}
