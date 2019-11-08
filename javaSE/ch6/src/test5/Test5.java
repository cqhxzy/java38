package test5;

import java.util.Calendar;

public class Test5 {
    public static void main(String[] args) {
        //默认当前时间
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, 1); //2月
        c.set(Calendar.YEAR,2020); //设置年份
        /*//同时设置年，月，日
        c.set(2018, 6, 31);
        int i = c.get(Calendar.MONTH) - 1;
        System.out.println(i);*/

        //c.add(Calendar.YEAR, 1); //在calendar表示的日期之上加一年
        //c.add(Calendar.DATE, 60);
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH) + 1);
        System.out.println(c.get(Calendar.DATE));
        //获取该月的最大天数
        System.out.println(c.getActualMaximum(Calendar.DATE));
        System.out.println(c.getMinimum(Calendar.DATE));
    }
}
