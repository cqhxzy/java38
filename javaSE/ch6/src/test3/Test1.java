package test3;

public class Test1 {
    public static void main(String[] args) {
        //声明字符串对象的几种方式
        String s1 = "abc";
        String s2 = new String();
        String s3 = new String("abc");

        char[] chars = {'a','b','c','d','e','f'};
        String s4 = new String(chars); //将char数组转换为字符串对象
        String s5 = new String(chars,0,5);

        String s6 = s1;
        String s7 = "abc";
       /* System.out.println(s1 == s6); //true
        System.out.println(s6 == s7); //true
        System.out.println(s1 == s3); //false
        System.out.println(s1.equals(s6)); //true*/

        s1 = "123"; //并不是修改123的值，而是修改了s1对象的内存地址

        String str1 = "atwyl";
        String str2 = "java";
        String str3 = "atwyljava";
        String str4 = str1 + str2; //atwyljava
        String str5 = (str1 + str2).intern(); //返回这个字符串值在内存中的标准写法

        System.out.println("1:" + str4.equals(str3));
        System.out.println("2:" + (str3 == str5));
    }
}
