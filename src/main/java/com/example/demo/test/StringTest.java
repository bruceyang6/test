package com.example.demo.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.test
 * @Description: TODO
 * @Dept: 星创产品部
 * @Date: Created in 2020/10/20 16:46
 */
public class StringTest {



    /*String str = new String("tedu");
    char [] arr = {'a','b','c'};

    public static void main(String[] args) {
        StringTest t = new StringTest();
        t.changes(t.str,t.arr);
        System.out.println("t.str = " + t.str+",arr[] =" +t.arr[0]);
    }
    public void changes(String str,char[] arr){
        System.out.println("str = " + str);
        System.out.println("arr = " + arr[0]);
        str = "bruce";
        arr[0] = 's';
    }*/


    public static void main(String[] args) {


        Map<String,String> map = new HashMap();
        map.put("1","zhangsan");
        map.put("2","lisi");
        map.put("3","wanger");
        map.put("4","mazi");
        String o = map.get("4");
        String s2 = map.get(null);





        String s = "abc";
        String s1 = new String("xyz");
        System.out.println("s = " + s+";s1 = " + s1);
        s = "abcd";
        s1 = new String("xyzw");
        System.out.println("s = " + s+";s1 = " + s1);
    }
}
