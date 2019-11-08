package homework;

public class Test19 {
    public static void main(String[] args) {
        int count = 1; //假设鸡蛋有1个
        while (!(count % 2 == 1 && count % 3 == 2 && count % 5 == 4)) {
            count++;
        }
        System.out.println(count);
    }
}
