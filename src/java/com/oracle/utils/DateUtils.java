package com.oracle.utils;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    //[1]将data转字符串（显示到浏览器中:2020-07-12 09:35:10）
    public static String date2String(Date date, String pattern){
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        String format=sdf.format(date);
        return format;
    }

    //[2]将字符串转成Date
    public static Date string2Date(String str,String pattern) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        Date parse=sdf.parse(str);
        return parse;
    }
}
