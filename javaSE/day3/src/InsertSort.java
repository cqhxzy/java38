import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        //插入排序
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int ran = (int)(Math.random() * 100) + 1; //随机生成1-100的随机数
            arr[i] = ran;
        }
        System.out.println("排序前：" + Arrays.toString(arr));

        //i从1开始：1代表第二个数，因为插入排序认为第一个数是有序的
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];
            int j = i; //从第2个数开始依次从右往左比较
            for (;j > 0 && arr[j - 1] > target;j--){
                arr[j] = arr[j - 1];
            }
            arr[j] = target;
        }

        System.out.println("排序后：" + Arrays.toString(arr));
    }
}
