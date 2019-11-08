package room2;

import java.util.Arrays;

public class Test3 {
    /**
     * 方法的引用传递
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5}; //0x001
        //在交换前输出arr中的元素
        System.out.println(Arrays.toString(arr));

        Test3 t3 = new Test3();
        //将arr传递到swap方法中时，swap方法栈和main方法栈中共享的是arr的内存地址
        t3.swap(arr); //将0x001传递到swap中

        System.out.println(Arrays.toString(arr)); //再来打印0x001的数组
    }

    public void swap(int[] arr){ //在main方法的案例中，arr对应0x001空间
        //对arr内存地址指向的空间中的元素位置交换
        for (int i = 0; i < arr.length / 2; i++) {
            int target = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = target;
        }
    }
}
