package test5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        System.out.println("请输入您的出生年月日，格式为：YYYY-MM-DD HH:mm:SS");
        Scanner input = new Scanner(System.in);
        //String str = input.nextLine();//接收下一行
        String str = "2019/11/2 13:24:10";

        Date date_obj = convertString2Date(str);
        //date.getTime()

        //获取日历的对象，默认当前时间
        Calendar calendar = Calendar.getInstance();
        //为Calendar指定时间
        //calendar.setTimeInMillis(date.getTime()); //通过毫秒设置
        calendar.setTime(date_obj);//通过Date对象设置Calendar

        //使用日历对象主要围绕两个方法
        //set(int,int)  为Calendar设置某个字段
        //get(int)  获取Calendar某个字段的值

        //获取年份
        int year = calendar.get(Calendar.YEAR);
        //月份,返回0-11的值
        int month = calendar.get(Calendar.MONTH) + 1;

        //获取日期 1-31
        int date = calendar.get(Calendar.DATE);

        //12小时制的小时
        int hour = calendar.get(Calendar.HOUR);
        //24小时制
        int hour_of_day = calendar.get(Calendar.HOUR_OF_DAY);

        //分
        int minute = calendar.get(Calendar.MINUTE);

        //秒
        int second = calendar.get(Calendar.SECOND);

        //获取日期为该年的第几周
        int week_of_year = calendar.get(Calendar.WEEK_OF_YEAR);
        //从日历上看，日期是这个月的第几周
        int week_of_month = calendar.get(Calendar.WEEK_OF_MONTH);
        int day_of_week_in_month = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        int DAY_OF_MONTH = calendar.get(Calendar.DAY_OF_MONTH);
        //周几
        int DAY_OF_WEEK = calendar.get(Calendar.DAY_OF_WEEK) - 1;



        StringBuilder sb = new StringBuilder();
        sb.append("年份：" + year)
                .append("\n月份：" + month)
                .append("\n几号：" + date)
                .append("\nhour：" + hour)
                .append("\nhour_of_day：" + hour_of_day)
                .append("\nminute：" + minute)
                .append("\nsecond：" + second)
                .append("\nweek_of_year：" + week_of_year)
                .append("\nweek_of_month：" + week_of_month)
                .append("\nday_of_week_in_month：" + day_of_week_in_month)
                .append("\nDAY_OF_MONTH：" + DAY_OF_MONTH)
                .append("\nDAY_OF_WEEK：" + DAY_OF_WEEK);
        System.out.println(sb.toString());

    }

    /**
     * 将字符串转换为日期的方法
     * @param dateStr
     * @return
     */
    private static Date convertString2Date(String dateStr){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date parse = null;
        try {
            parse = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            parse = new Date();//默认系统当前时间
            System.out.println("出现异常");
        }
        return parse;
    }
}
