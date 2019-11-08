package homework;

public class Test11 {
    public static void main(String[] args) {
        /*
        * 某个商店搞活动，每3个空的饮料瓶子可以换一瓶新的饮料，现在你有20个空瓶子，请按照此活动的换法，你一个可以喝到多少瓶饮料(包含你自己的20瓶饮料)
        * */
        int empty = 20;
        int bottle = empty;
        while (empty >= 3) {//只要空瓶子的数量大于等于3个，则继续换
            bottle += empty / 3;
            empty = empty / 3 + empty % 3;
        }
        System.out.println("20个空瓶子一共可以喝" + bottle + "瓶饮料");
    }
}
