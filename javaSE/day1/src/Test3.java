public class Test3 {
    public static void main(String[] args) {
        //1-100累加求和
        int i = 1; // 循环变量
        int sum = 0; //用于接收总和
        while (i <= 100) {
            //sum = sum + i;
            sum += i;
            i++;
        }

        System.out.println("1-100累加求和：" + sum);
    }
}
