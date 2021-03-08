package com.example.demo2;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo2
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2021/2/19 13:37
 */
public class TestA {

    /**
     *给定两个字符串str1和str2,输出两个字符串的最长公共子串，如果最长公共子串为空，输出-1。
     * 比如："ab123cd"，"a123456c"，
     * 返回："123"，
     * 备注：1≤|str1|,|str2|≤5000
     */
    public static void main(String[] args) {
        String str1 = "ab123cd";
        String str2 = "a123456c";
//        String result = lcsUseIterator(str1, str2);
//        String result = lcsUseMap(str1, str2);
        String result = lcsUseDynamicProgram(str1, str2);
        System.out.println("result = " + result);

    }
    /**
     * 获取最长公共字符串 longest common string
     * @param str1
     * @param str2
     * @return
     */
    public static String lcsUseIterator(String str1,String str2){

        if(StringUtils.isBlank(str1) || StringUtils.isBlank(str2)){
            return "-1";
        }
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int maxLength = 0;//出现最大子串长度
        int maxEndIndex = 0;//出现最大子串的最后一个字符在str1中的下标
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                if(s1[i] == s2[j]){
                    int tempIndex1 = i;
                    int tempIndex2 = j;
                    int maxTemp = 0;// 本次迭代中最大子串长度
                    while (tempIndex1 < s1.length && tempIndex2 < s2.length && s1[tempIndex1] == s2[tempIndex2]){
                        tempIndex1++;
                        tempIndex2++;
                        maxTemp++;
                    }
                    if(maxTemp > maxLength){
                        maxLength = maxTemp;
                        maxEndIndex = tempIndex1;
                    }
                }
            }
        }
        if(maxLength == 0){
            return "-1";
        }else {
            return str1.substring(maxEndIndex - maxLength,maxEndIndex);
        }
    }

    /**
     * 获取最长公共字符串 longest common string
     * @param str1
     * @param str2
     * @return
     */
    public static String lcsUseMap(String str1,String str2){
        //方法入口，惯例校验参数
        if(StringUtils.isBlank(str1) || StringUtils.isBlank(str2)){
            return "-1";
        }
        //先将数据都转为char数组
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        Map<Character,String> char2Map = new HashMap<>(charArr1.length);
        for (int i = 0; i < charArr2.length; i++) {
            if(char2Map.containsKey(charArr2[i])){
                char2Map.put(charArr2[i],char2Map.get(charArr2[i])+","+i);
            }else {
                char2Map.put(charArr2[i],i+"");
            }
        }
        int max = 0;//出现的最大公共长度
        int maxIndex = 0;
        for (int i = 0; i < charArr1.length; i++) {
            if(char2Map.containsKey(charArr1[i])){
                String index2Arr = char2Map.get(charArr1[i]);
                List<Integer> indexList = Stream.of(index2Arr.split(",")).map(Integer::parseInt).collect(Collectors.toList());
                for (Integer index2 : indexList) {
                    int tempIndex1 = i;
                    int tempCommonLength = 0;
                    while (index2 < charArr2.length && tempIndex1 < charArr1.length &&
                    charArr1[tempIndex1] == charArr2[index2]){
                        tempIndex1++;
                        index2++;
                        tempCommonLength++;
                    }
                    if(tempCommonLength > max){
                        max = tempCommonLength;
                        maxIndex = i;
                    }
                }
            }
        }
        if(max == 0){
            return "-1";
        }else {
            return str1.substring(maxIndex,maxIndex+max);
        }
    }
    /**
     * 获取最长公共字符串 longest common string
     * @param str1
     * @param str2
     * @return
     */
    public static String lcsUseDynamicProgram(String str1,String str2){
        //方法入口，惯例校验参数
        if(StringUtils.isBlank(str1) || StringUtils.isBlank(str2)){
            return "-1";
        }
        //先将数据都转为char数组
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        int size1 = charArr1.length;
        int size2 = charArr2.length;

        int[][] dp = new int[size1+1][size2+1];
        for (int i = 0; i <= size1; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        int maxLength = 0;
        int maxIndexInChar1 = 0;
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                if(charArr1[i] != charArr2[j]){
                    dp[i+1][j+1] = 0;
                }else {
                    dp[i+1][j+1] = dp[i][j] + 1;
                    if(dp[i+1][j+1] > maxLength){
                        maxLength = dp[i+1][j+1];
                        maxIndexInChar1 = i;
                    }
                }
            }
        }
        if(maxLength == 0){
            return "-1";
        }else {
            return str1.substring(maxIndexInChar1+1-maxLength,maxIndexInChar1+1);
        }
    }
}
