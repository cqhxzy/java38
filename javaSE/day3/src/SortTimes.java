import java.util.Arrays;

public class SortTimes {

    public static void main(String[] args) {
        System.out.println("开始初始化长度为10万的随机数组");
        final int LENGTH = 100000;
        int[] arr = new int[LENGTH];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * LENGTH);
        }

        //复制数组到另一个数组中
        int[] arr2 = new int[LENGTH];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[i];
        }

        System.out.println("初始化数组完成开始排序...");

        //long bubbleSort = bubbleSort(arr);
        long chooseSort = chooseSort(arr);
        long quickSort = quickSort(arr2);

        //System.out.println("冒泡排序耗时(毫秒)：" + bubbleSort);
        System.out.println("选择排序耗时(毫秒)：" + chooseSort);
        System.out.println("快速排序耗时(毫秒)：" + quickSort);
    }

    /**
     * 通过这个方法可以为arr这个数组进行冒泡排序
     * 最终返回冒牌排序这个arr数组消耗的时间
     * @param arr
     * @return
     */
    public static long bubbleSort(int[] arr){
        //在开始排序之前记录系统当前时间
        long start = System.currentTimeMillis();//返回从1970-1-1 0:0:0 至今经历的毫秒

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    int target = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = target;
                }
            }

        }

        long end = System.currentTimeMillis(); //记录结束时间
        long time = end - start; //排序消耗时间
        return time;
    }

    public static long chooseSort(int[] arr){
        //在开始排序之前记录系统当前时间
        long start = System.currentTimeMillis();//返回从1970-1-1 0:0:0 至今经历的毫秒

        //选择排序
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

        long end = System.currentTimeMillis(); //记录结束时间
        long time = end - start; //排序消耗时间
        return time;
    }

    public static long quickSort(int[] arr){
        //在开始排序之前记录系统当前时间
        long start = System.currentTimeMillis();//返回从1970-1-1 0:0:0 至今经历的毫秒

        //通过快速排序对arr2排序
        Arrays.sort(arr);

        long end = System.currentTimeMillis(); //记录结束时间
        long time = end - start; //排序消耗时间
        return time;
    }
}
