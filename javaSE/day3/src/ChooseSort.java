import java.util.Arrays;

public class ChooseSort {
    /**
     * 选择排序
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int ran = (int)(Math.random() * 100) + 1; //随机生成1-100的随机数
            arr[i] = ran;
        }

        //输出排序之前的数组序列
        System.out.println("排序前：" + Arrays.toString(arr)); //将数组转换为string字符串

        for (int i = 0; i < arr.length - 1; i++) {
            //假设当前i对应的值是数组中最小的
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {//下标为j的值比下标为min的值还要小
                    min = j; //记录下标最小的值为j
                }
            }
            //经过内层循环一遍循环后，能够确定的是数组中最小值的下标
            if (min != i) { //交换位置
                int target = arr[min];
                arr[min] = arr[i];
                arr[i] = target;
            }
        }

        System.out.println("排序前：" + Arrays.toString(arr));
    }
}
