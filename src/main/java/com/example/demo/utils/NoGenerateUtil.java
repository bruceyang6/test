package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.utils
 * @Description: TODO
 * @Dept: 星创产品部
 * @Date: Created in 2020/8/10 14:52
 */
public class NoGenerateUtil {

    public synchronized static String getOrderId(){
        String orderId=""+(Math.round(Math.random()*80000000)+100000)+"";
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String date = format.format(new Date());
        orderId = date + orderId;
        return orderId;
    }
}
