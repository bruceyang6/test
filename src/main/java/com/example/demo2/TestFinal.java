package com.example.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo2
 * @Description: TODO
 * @Dept: 星创产品部
 * @Date: Created in 2021/2/2 17:48
 */
public class TestFinal {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");

        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");
        list.addAll(list2);
        for (String s : list) {
            System.out.println("s = " + s);
        }
    }
}
