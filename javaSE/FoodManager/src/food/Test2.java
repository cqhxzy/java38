package food;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        int delete_index = 2; //被删除元素的下标
        System.out.println("删除前：" + Arrays.toString(arr));

        System.arraycopy(arr,delete_index + 1,arr,delete_index,arr.length - 1 - delete_index);
        arr[arr.length - 1] = 0;

        System.out.println("删除后：" + Arrays.toString(arr));
    }
}
