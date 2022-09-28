package com.example.demo.test;

/**
 * @Author: bruceyang
 * @Description: <一句话描述该类功能/>
 * @Date: Created in 13:28 2022/2/25
 * @Modified By:
 */
public class TestLeetCode {

    /**
     * 求两个字符串的最大公共子串
     * abc1234565789dd
     * a123456abc123456dd
     *
     * 输出：abc123456
     * @param args
     */

    public static void main(String[] args) {

        String str1 = "abc1234565789dd";
        String str2 = "123456abc123456dd";
        // 嵌套for循环
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        // 子串最大长度
        int maxlength = 0;
        // 子串最后一位字符所在下标
        int maxEndIndex = 0;

        // 首先定位相同公共字符
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if(chars1[i] == chars2[j]){
                    int m =i;
                    int n =j;
                    // 本次子串的最大长度
                    int tempMax = 0;
                    while(m < chars1.length && n<chars2.length && chars1[m] == chars2[n]){
                        tempMax ++;
                        m ++;
                        n ++;
                    }
                    if(tempMax > maxlength){
                        maxlength = tempMax;
                        maxEndIndex = m;
                    }
                }
            }
        }

        String result = str1.substring(maxEndIndex - maxlength, maxEndIndex);
        System.out.println("result = " + result);
    }
}
