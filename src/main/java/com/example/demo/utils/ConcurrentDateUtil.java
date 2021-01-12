package com.example.demo.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.utils
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/25 15:43
 */
public class ConcurrentDateUtil {

    public static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static Date parse(String str)throws ParseException {
        return threadLocal.get().parse(str);
    }
    public static String format(Date date){
        return threadLocal.get().format(date);
    }

    public static ThreadLocal<DateFormat> local = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMddHHmmssSSS");
        }
    };
    public static Date parseStr(String str)throws ParseException {
        return local.get().parse(str);
    }
    public static String formatDate(Date date){
        return local.get().format(date);
    }
}
