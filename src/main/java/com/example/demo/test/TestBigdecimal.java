package com.example.demo.test;

import com.example.demo.entity.Students;

import java.math.BigDecimal;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.test
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/8/27 15:17
 */
public class TestBigdecimal {

    public static void main(String[] args) {



        BigDecimal bigDecimal = new BigDecimal(0.3);
        System.out.println(bigDecimal);
        String s = formatBigDecimal(bigDecimal);
        System.out.println("s = " + s);
        BigDecimal bigDecimal1 = getBigDecimal(bigDecimal);
        System.out.println("bigDecimal1 = " + bigDecimal1);

    }




    public static String formatBigDecimal(BigDecimal val) {
        return formatBigDecimal(val, 2);
    }
    public static String formatBigDecimal(BigDecimal val, int size) {
        if (size < 0) {
            //当size小于零直接返回空字符串
            return "";
        }
        if (null == val || BigDecimal.ZERO.compareTo(val) >= 0) {
            return BigDecimal.ZERO.setScale(size, BigDecimal.ROUND_HALF_UP).toPlainString();
        } else {
            return val.setScale(size, BigDecimal.ROUND_HALF_UP).toPlainString();
        }
    }


    public static BigDecimal getBigDecimal(Object val) {
        if (val == null) {
            return new BigDecimal(0);
        }
        if (val instanceof BigDecimal) {
            return (BigDecimal) val;
        }
        if (val instanceof String) {
            return new BigDecimal(val.toString());
        }
        if (val instanceof Integer) {
            Integer valInt = (Integer) val;
            return new BigDecimal(valInt);
        }
        if (val instanceof Long) {
            Long valLong = (Long) val;
            return new BigDecimal(valLong);
        }
        if (val instanceof Double) {
            Double valDouble = (Double) val;
            return new BigDecimal(valDouble);
        }
        return new BigDecimal(0);
    }
}
