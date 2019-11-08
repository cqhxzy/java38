package room2;

/**
 * 理解方法的值传递和引用传递的区别
 */
public class Test2 {

    /**
     * 方法的值传递
     * @param a
     * @param b
     */
    public void swap(int a,int b){

        int c = a;
        a = b;
        b = c;

        System.out.println("交换后：a=" + a + ",b=" + b);
    }


    public static void main(String[] args) {
        Test2 t2 = new Test2();
        int a = 1;
        int b = 10;
        System.out.println("交换前：a=" + a + ",b=" + b);
        t2.swap(a,b);//swap方法负责交换a和b的值，并输出
        System.out.println("第三次输出：a=" + a + ",b=" + b);
    }
}
