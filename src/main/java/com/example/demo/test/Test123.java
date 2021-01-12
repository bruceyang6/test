package com.example.demo.test;

import com.example.demo.entity.Person;
import com.example.demo.test.database.DataFactory;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.test
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/25 17:16
 */
public class Test123 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        for (String name : list) {
            list.clear();
            list.add("5");
        }
        A a = new A();
        a.out();
        String[] msgArr = new String[]{"我","是"};
        String collect1 = Arrays.asList(msgArr).stream().collect(Collectors.joining("、"));

        List<Person> personList = DataFactory.getPersonList();
        List<HashMap<String, Object>> mapList = personList.stream().map(s -> {
            HashMap<String, Object> map = new HashMap<>();
            map.put(s.getId(), s);
            return map;
        }).collect(Collectors.toList());
        for (HashMap<String, Object> map : mapList) {
            System.out.println("map = " + map);
        }


        System.out.println("collect1 = " + collect1);

        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime now = LocalDateTime.now(zoneId);//2020-09-25T17:20:42.678
        System.out.println(now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        /**
        * FormatStyle.LONG ：2020年9月25日 下午05时22分16秒
        * FormatStyle.FULL
        * FormatStyle.SHORT:20-9-25 下午5:23
        * FormatStyle.MEDIUM:2020-9-25 17:24:18
        * */
    }
    static class A {
        int a ;
        boolean f ;
        String s ;
        public void out(){
            System.out.println("a = " + a);
            System.out.println("f = " + f);
            System.out.println("s = " + s);
        }
    }
}
