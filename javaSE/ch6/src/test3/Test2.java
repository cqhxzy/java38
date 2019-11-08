package test3;

public class Test2 {
    public static void main(String[] args) {
        String str1 = "abc" + "123" +"def";
        //如果需要频繁的拼接字符串，就不要使用+号
        //java中通过StringBuilder和StringBuffer对字符串拼接
        //字符串是不可变序列，StringBuilder和StringBuffer是可变的。
        //StringBuilder和StringBuffer的用法相同
        //区别：StringBuffer是线程安全的对象。StringBuilder是线程非安全的对象
        //在多线程环境中，建议使用StringBuffer,在单线程环境中，使用StringBuilder
        StringBuilder builder = new StringBuilder();
        /*builder.append("abc"); //在字符串末尾拼接字符串
        builder.append("123");
        builder.append("def");*/

        //链式编程
        builder.append("abc")
                .append("123")
                .append("def");

        //将StringBuilder转换为String
        String s = builder.toString();
        System.out.println(str1.equals(s));
    }
}
