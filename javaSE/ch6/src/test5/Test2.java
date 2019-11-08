package test5;

import java.util.Date;

public class Test2 {
    public static void main(String[] args) {
        //返回系统当前时间
        Date date = new Date(); //2019
        System.out.println(date);

        //根据long类型的变量实例化Date对象
        //long类型的变量代表了1970-1-1 0:0:0 经历的毫秒数
        Date date1 = new Date(630720000000L); //1989
        System.out.println(date1);

        //日期可以通过long类型的变量表示
        long time = date.getTime();//这个日期对象的毫秒数
        System.out.println(time);

        boolean before = date.before(date1);//判断date是否比date1小
        boolean after = date.after(date1); //判断date是否比date1大
        System.out.println(before);
        System.out.println(after);
    }
}
