public class Test7 {

    public static void main(String[] args) {
        //输出1-100所有偶数的和
        int sum = 0;
        for (int i = 1; i <= 100; i++) {

            /*if (i % 2 == 0) {
                sum += i;
            }*/

            if (i % 2 != 0) {
                continue; //放弃本次循环的执行
            }

            sum += i; //将偶数累加求和
        }
        System.out.println("1-100所有偶数的和：" + sum);
    }
}
