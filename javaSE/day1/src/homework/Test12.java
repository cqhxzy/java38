package homework;

public class Test12 {
    /**
     * 你现在有9个朋友，现在都比较渴，刚好又遇到商店搞活动，每3个空的饮料瓶子可以换一瓶新的饮料，你为了节省开支，最多买几瓶就够你的朋友喝了
     * @param args
     */
    public static void main(String[] args) {
        final int COUNT = 9; //总共有9个人
        int total = 1; //要购买的饮料

        while (true) {//死循环
            int empty = total;
            int bottle = total;
            while (empty >= 3) {
                bottle += empty / 3;
                empty = empty / 3 + empty % 3;
            }

            if (bottle >= COUNT) {
                break; //结束外层循环
            } else {
                total++;
            }
        }
        System.out.println("总共买" + total + "瓶饮料足够" + COUNT + "个人喝");
    }
}
