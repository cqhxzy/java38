public class Demo1 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = new int[]{1,2,3,4,5};

        int[] arr3 = new int[5]; //声明了一个长度为5的数组

        System.out.println(arr1); //输出内存地址
        byte b = 127;
        arr1[0] = b; //满足自动类型转换
        arr1[1] = 66;

        /*System.out.println(arr1[0]);
        System.out.println(arr1[1]);
        System.out.println(arr1[5]);*/

        arr3[0] = 9;
        System.out.println(arr3[0]);
        System.out.println(arr3[1]);
    }
}
