package com.wisezone.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverterUtil {

    /**
     * 将Timestamp类型转换为java.util.Date
     * @param timestamp
     * @return
     */
    public static Date timeStamp2Date(Timestamp timestamp){
        if (timestamp == null) {
            return null;
        }
        return new Date(timestamp.getTime());
    }

    /**
     * 将java.util.Date转换为字符串
     * @param date
     * @return
     */
    public static String date2String(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        return format;
    }
}
