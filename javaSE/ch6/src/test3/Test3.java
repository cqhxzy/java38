package test3;

import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(str.length());//返回字符串字符的个数的方法
        System.out.println(str.charAt(0));//获取字符串中第0个字符
        System.out.println(str.equals("abcdefg"));//每个字符逐一比较

        //compareTo方法来自于Compareable接口，这个方法返回一个int类型的值
        //如果两个字符串相同，则返回0，如果被比较的比比较的字符串大，则返回正数，否则返回负数
        //基于compareTo可以实现自然排序。
        //在集合章节再做深入研究
        System.out.println("a".compareTo("a"));
        System.out.println("a".compareTo("c"));
        System.out.println("10".compareTo("0"));

        //indexOf方法，返回指定字符串第一次出现的索引
        System.out.println("abcdef".indexOf("b"));
        System.out.println("abcdefc".indexOf("efc"));
        //在字符串中查找c从指定索引开始第一次出现的索引
        System.out.println("abcdefc".indexOf(
                "c",
                "abcdefc".indexOf("c") + 1
        ));

        //从右往左，查找字符串第一次出现的位置
        System.out.println("abcdefc".lastIndexOf("c"));
        System.out.println("abcdefc".lastIndexOf("c","abcdefc".lastIndexOf("c") - 1));

        //判断字符串是否已某个字符串开始
        System.out.println("abcdefc".startsWith("a"));
        //判断字符串是否已某个字符串结束
        System.out.println("abcdefc".endsWith("c"));

        boolean b = "130123456789".regionMatches(3, "1234", 0, 4);
        System.out.println(b);

        String substring = "abc123abc".substring(3);//从索引为3开始截取到字符串末尾
        System.out.println(substring);
        System.out.println("abc123abc".substring(3,6));//从索引为3开始截取到索引为6之间的字符串

        System.out.println("abcabc".replace('a','*'));
        //按照正则表达式匹配，替换匹配的字符串
        System.out.println("abc123abc".replaceAll("abc","*"));
        //去除字符串首尾的空格，不包含字符串内部的空格
        System.out.println("   123 abc 123  ".trim());
        //拼接字符串
        System.out.println("123".concat("abc")); //123abc

        //根据正则表达式，将字符串分隔为字符串数组
        String str_arr = "1|2|3|4";
        String[] split = str_arr.split("\\|"); //因为|是正则表达式中的或者  \|
        System.out.println(Arrays.toString(split));

        String s1 = "abcd";
        String s2 = "efg";
        String concat = s1.concat(s2); //abcdefg
        System.out.println(str == concat);
    }
}
