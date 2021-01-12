package com.example.demo.test;


import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.test
 * @Description: lambda 实现九九乘法表 即嵌套for循环
 * @Dept: 星创产品部
 * @Date: Created in 2020/8/27 13:47
 */
public class TestLambdaMultipty {

    public static void main(String[] args) {
//        functionOne();
//        System.out.println("分割线---------------------------------------");
//        functionTwo();
//        functionThree();
        noLimit();
    }

    public static void noLimit(){
        Map<String,Object> map = Maps.newHashMap();
        int j = 0;
        long startTime = System.currentTimeMillis();
        for(int i = 20;i>0;i--){
            double random = Math.random();
            System.out.println("random = " + random);
            j++;
            System.out.println("已经生成" + j +"个随机数");
            map.put(j+"",random);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时 = " + (endTime - startTime)+"秒");
        for (String s : map.keySet()) {
            System.out.println("k = " + s+",v = "+map.get(s));
        }


    }

    public static void functionTwo(){
        Stream.iterate(1,e -> e+1).limit(9).forEach(e -> {
            Stream.iterate(1,ee -> ee+1).limit(e).forEach(ee -> {
                System.out.print(ee + "*" + e + "=" + ee*e +"\t");
            });
            System.out.println();
        });
    }

    public static void functionOne(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> integerStream = list.stream().filter(e -> e < 5);
        List<Integer> collect = list.stream().filter(e -> e < 5).peek(System.out::println).collect(Collectors.toList());
        long count = list.stream().filter(e -> e < 5).count();
        list.forEach((e) -> {
            list.stream().filter((ee) -> ee <= e)
                    .forEach((eee) -> System.out.print(eee + "*" + e + "=" + eee*e +"\t"));
            System.out.println();
        });
    }

    public static void functionThree(){
        for (int i = 1 ;i<= 9;i++){
            for (int j = 1;j <= i;j++){
                System.out.print(j +"*"+ i + "="+j*i+"\t");
            }
            System.out.println();
        }
    }
}
