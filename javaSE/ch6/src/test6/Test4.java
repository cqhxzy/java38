package test6;

import java.util.Random;

public class Test4 {
    public static void main(String[] args) {
        //产生int类型返回的随机数
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int ran = random.nextInt(10);
            System.out.println(ran);
        }
    }
}
