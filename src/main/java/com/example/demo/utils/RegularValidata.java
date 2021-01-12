package com.example.demo.utils;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.utils
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/17 11:47
 */
public class RegularValidata {

    public static boolean validataBigdecimal(Object obj) {
        boolean flag = false;
        try {
            if (obj != null) {
                String source = new BigDecimal(obj.toString()).toString();
                // 判断是否是整数或者是携带一位或者两位的小数
                Pattern pattern = Pattern.compile("^[+]?([0-9]{1,9}(.[0-9]{1,2})?)$");
                if (pattern.matcher(source).matches()) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return flag;
    }
}
