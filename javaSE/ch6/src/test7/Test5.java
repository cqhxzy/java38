package test7;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test5 {
    public static void main(String[] args) {
        String[] names = {"zhangsan","lisi","a","wangwu","lilei","hanmeimei"};
        //test1(names);
        test2(names);
    }

    private static void test1(String[] names) {
        StringBuilder builder = new StringBuilder();
        //将数组中每个元素的首字母变成大写，并拼接成字符串
        for (String n : names) {
            //截取第一个字符，然后改为大写
            if (n.length() > 1){
                String firstLetter = n.substring(0, 1).toUpperCase();
                String other = n.substring(1);
                builder.append(firstLetter)
                        .append(other)
                        .append(",");
            }
        }
        String str = builder.toString();
        str = str.substring(0,str.length() - 1);
        System.out.println(str);
    }

    /**
     * JDK Stream结合Lambda表达式实现test1的功能
     * @param names
     */
    private static void test2(String[] names){
        String collect = Stream.of(names)
                //(t)代表着Predicate接口中的test方法的参数t
                //filter中接收一个Predicate接口的对象
                //函数式编程的接口中只有一个方法，因此filter方法中的代码无非就是
                //Predicate接口的匿名实现。他是一个代码块
                .filter(t -> t.length() > 1) //只要名字长度大于1的名字
                //传到map方法中的参数是名字，返回是首字母大写的名字
                .map(n -> {
                    String firstLetter = n.substring(0, 1).toUpperCase();
                    String other = n.substring(1);
                    return firstLetter + other;
                })
                //收集，将每个名字用逗号分隔
                .collect(Collectors.joining(","));
        System.out.println(collect);
    }


}
