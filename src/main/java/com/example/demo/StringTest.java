package com.example.demo;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: PACKAGE_NAME
 * @Description: TODO
 * @Dept: 星创产品部
 * @Date: Created in 2020/8/5 13:48
 */
public class StringTest {

    public static void main(String[] args) {
        //
        String ids = "1,2,3,4";
        List<String> arr = Arrays.asList(ids.split(","));
        for (int i = 0 ; i < arr.size(); i++) {
            if(StringUtils.equals(arr.get(i),"1")){
                Collections.replaceAll(arr,"1","一级");
            }
        }
        System.out.println("ids1 = " + arr.stream().collect(Collectors.joining(",")));


        String s = "qwertyuiop";
        if(checkDifferent(s)){
            System.out.println("存在重复的字符信息 = " );
        }else {
            System.out.println("不存在重复的字符信息 = " );
        }

    }

    private static boolean checkDifferent(String iniString) {
        boolean isBool = false;
        char[] chars = iniString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    isBool = true;
                    return isBool;
                } else {
                    isBool = false;
                }
            }
        }
        return false;
    }
}
