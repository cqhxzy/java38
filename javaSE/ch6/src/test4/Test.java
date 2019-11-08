package test4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入手机号");
        String phone = input.next();

        String regex = "^1[356789]\\d{9}$";
        String id_regex = "\\d{18}|\\d{17}[xX]";

        Pattern compile = Pattern.compile(regex); //编译正则表达式
        Matcher matcher = compile.matcher(phone);
        boolean matches = matcher.matches(); //使正则表达式开始工作，验证手机号是否合法
        System.out.println(matches?"合法":"不合法");

        Pattern compile1 = Pattern.compile(id_regex);
        Matcher matcher1 = compile1.matcher("50022919990101256x");
        boolean matches1 = matcher1.matches();
        System.out.println(matches1);

        boolean matches2 = Pattern.matches(regex, phone);//Pattern提供的方法
        boolean matches3 = phone.matches(regex);//String提供的方法

    }
}
