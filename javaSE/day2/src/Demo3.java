public class Demo3 {
    public static void main(String[] args) {
        int[][] arr = new int[5][3];
        //System.out.println(arr.length);  //一维数组的长度
       // System.out.println(arr[0].length); //获取一维数组中每个元素（int[]） 的长度
        arr[1][0] = 5;

        int[][] arr2 = new int[3][];
        int[] a1 = new int[10]; //额外创建了一个int数组
        arr2[0] = a1; //将a1数组保存到arr2数组下标为0的空间
        for (int i = 0; i < arr2.length; i++) {
            int[] a = arr2[i]; //获取数组下标为i的二维数组
            System.out.print(a.length + " "); //数组为引用数据类型，输出的是内存地址
        }
    }
}
