package test6;

import java.util.UUID;

public class Test6 {
    public static void main(String[] args) {
        //生成唯一的字符串
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        System.out.println(s);

        String s1 = s.toUpperCase();
        String s2 = s1.replaceAll("-", "");
        System.out.println(s2);
    }
}
