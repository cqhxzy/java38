package homework;

public class Test13 {
    /**
     * 求1-1000之中所有带3的数,15个一行进行输出，并统计总的 个数
     * @param args
     */
    public static void main(String[] args) {
        int count = 0;//统计3的个数
        for (int i = 1; i <= 1000 ; i++) {

            int temp = i; //将i的值赋值给temp
            //判断temp是否包含3
            boolean flag = false; //假设不包含3
            int n;
            while (temp > 0) {
                n = temp % 10;
                if (n == 3) {
                    flag = true; //这个数字包含3
                    break;
                }
                temp /= 10; //缩小10倍
            }

            if (flag) { //说明当前i这个数包含3
                System.out.print(i + " ");
                count++;
                if (count % 15 == 0) { //每15个一行
                    System.out.println();//换行显示
                }
            }
        }
        System.out.println("\n总个数为：" + count);
    }
}
