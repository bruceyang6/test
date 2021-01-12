package com.example.demo.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Students;
import com.example.demo.nutrition.NutritionFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.test
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/9 14:00
 */
public class TestArrayList {

    public static void main(String[] args) {

//        Students students = new Students(1L,"张三","男",18,"100",null,100.0,new BigDecimal("10"));
        Students students = new Students();
        Employee employee = new Employee();
        if(null == employee){
            System.out.println("1111111 = " + 1111111);
        }else {
            System.out.println("2222222 = " + 2222222);
        }
        
        
        boolean result = getList(students);


        List<NutritionFactory> nutritionFactories = new ArrayList<>();
        NutritionFactory.Builder builder = new NutritionFactory.Builder(1, 2);
        NutritionFactory nutritionFactory = new NutritionFactory(builder);
        nutritionFactories.add(nutritionFactory);
//        System.out.println("nutritionFactory.toString() = " + nutritionFactory.toString());

        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("麻子");
        list.add(3,"二哥");
//        list.remove(2);
        String stripChars = "[]";
//        String listStr = list.toString();
        String listStr = "[[[张三, 李四, 麻子, 二哥]]]";
        String s = stripStr(listStr, stripChars);
//        System.out.println("list.toString() = " + StringUtils.strip(list.toString(),"[]"));
        System.out.println("s = " + s);

        /** 返回一个0-2^bitLength 之间随机数 */
        BigInteger bigInteger = BigInteger.probablePrime(3, new Random());
        System.out.println("bigInteger = " + bigInteger);

        int highBit = 1 << ((2+31) & 0x1f);
        System.out.println("highBit = " + highBit);

        /*BigInteger bigInteger1 = new BigInteger(2, 2, new Random());
        System.out.println("bigInteger1 = " + bigInteger1);*/
        /*ArrayList<Integer> integers = new ArrayList<Integer>() {{
            add(1);
            add(2);
        }};
        String s = integers.toString();
        String[] split = StringUtils.split(s, ",");
        List<String> splitList = Arrays.asList(split);
        List<Integer> collect = splitList.stream().map(ab -> Integer.valueOf(ab)).collect(Collectors.toList());

        System.out.println("s = " + s);
        List<Integer> integers1 = JSONArray.parseArray(s, Integer.class);
        for (Integer integer : integers1) {
            System.out.println("integer = " + integer);
        }*/

    }
    private static String stripStr(String str,String stripChars){
        if(StringUtils.isBlank(str)){
            return str;
        }
        int start = 0;
        int end;
        while (start != str.length() && stripChars.indexOf(str.charAt(start)) != -1){
            start ++;
        }
        String startStr = str.substring(start);
        end = startStr.length();
        while(end != 0 && stripChars.indexOf(startStr.charAt(end - 1)) != -1){
            end --;
        }
        return startStr.substring(0,end);
    }

    private static boolean getList(Students students){
        if(Objects.nonNull(students)){
            System.out.println("students不为空 = " + students);
            return true;
        }else {
            System.out.println("students为空 = " + students);
            return false;
        }
    }
}
