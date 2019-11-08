package test5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test3 {
    public static void main(String[] args) {
        //str2Date();
        date2Str();
    }

    /**
     * 将字符串格式的日期转换为Date对象
     */
    private static void str2Date(){
        String str = "2019/11/05 09:33:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            Date parse = sdf.parse(str);
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将日期对象转换为字符串类型
     */
    private static void date2Str(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss 年周：w 月周:W-F E a");
        String format = sdf.format(date);
        System.out.println(format);
    }
}
