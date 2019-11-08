import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int ran = (int)(Math.random() * 100) + 1; //随机生成1-100的随机数
            arr[i] = ran;
        }

        //输出排序之前的数组序列
        System.out.println("排序前：" + Arrays.toString(arr)); //将数组转换为string字符串

        /*
         *  N个数字来排队，两两相比小靠前，外层循环N-1，内层循环N-1-i
         * */
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    int target = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = target;
                }
            }

        }

        System.out.println("排序后：" + Arrays.toString(arr));
    }
}
