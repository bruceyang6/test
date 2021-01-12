package com.example.demo;

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
