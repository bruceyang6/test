package com.example.demo.test;

import com.example.demo.utils.CompareDateFormat;
import com.google.common.collect.Maps;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.test
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/8/19 13:42
 */
public class TestSubString {

    public static void main(String[] args) throws Exception {

        Integer[] simple = new Integer[10];
        Random random = new Random(1000);
        for (int i = 0;i<simple.length;i++) {
            simple[i] = random.nextInt();
        }



        String str2 = "good";
        String str1 = new String("go") + new String("od");
        System.out.println(str1.intern() == str1);
        System.out.println(str1 == "good");

//        String a ;
//        String b = a+1;
        /**
         * Arrays.asList() 主要是将数组转换成list，如果不需要改变长度，即不支持add和remove
         * */
        String [] str = {"aa","bb","ee"};
        List<Object> list = Arrays.asList(str);
        String join = StringUtils.join(list, ",");
//        System.out.println("join = " + join);
        HashMap<String, String> map = Maps.newHashMap();
        map.put("partnerName","阿里妈妈");
        map.put("no","456879");
        List<EntityOne> entityOnes  = new ArrayList<>();
        EntityOne entityOne = new EntityOne();
        entityOne.setPartnerName(map.get("partnerName"));
        entityOne.setNo(map.get("no"));
        entityOnes.add(entityOne);
        entityOnes.stream().forEach(System.out::println);
        /** 初始化一个list集合，并完成add */
        ArrayList<String> strings = new ArrayList<String>() {{
            add("aa");
            add("bb");
        }};

        String s = "abcd";
        String s1 = s.substring(0, 1).toUpperCase();
//        System.out.println("s1 = " + s1);
        String substring = s.substring(1);
//        System.out.println("substring = " + substring);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String registerDate = "2018-12-25 00:00:00";
        String issueDate = "2018-12-26 00:00:00";
        int compare = CompareDateFormat.compareDateFormat(issueDate, registerDate);
        if(compare != 1){
            throw new RuntimeException("发证日期必须大于注册日期！");
        }

    }
}
@Data
class EntityOne{
    private String partnerName;
    private String no;

}