package com.example.demo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.utils.NoGenerateUtil;
import com.example.demo.utils.UUIDGenerator;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.test
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/8/10 15:16
 */
public class TestNoGeneratorUtil {

    public static void main(String[] args) {
        String orderId = NoGenerateUtil.getOrderId();
        System.out.println("orderId = " + orderId);

        String s3 = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        System.out.println("s3 = " + s3);

        String s4 = s3.substring(8,24);
        System.out.println("s4 = " + s4);

        JSONObject json = new JSONObject();
        json.put("adcode","610100");
        json.put("location","105.321" + "," + "26.213");

        String s = JSON.toJSONString(json);
        System.out.println("s = " + s);
        JSONObject jsonObject = JSONObject.parseObject(s);
        String location = jsonObject.getString("location");
        String[] split = StringUtils.split(location, ",");
        List<String> strings = Arrays.asList(split);
        strings.stream().forEach(System.out::println);

        String s1 = strings.toString();
        System.out.println("s1 = " + s1);
        String s2 = s1.replaceAll("(?:\\[|null|\\]| +)", "");
        System.out.println("s2 = " + s2);
        //关于去掉list.toString()方法后，[]问题，以下两种方法最优
        String strip = StringUtils.strip(s1, "[]");
        System.out.println("strip = " + strip);
        String collect = strings.stream().collect(Collectors.joining(","));
        System.out.println("collect = " + collect);
    }
}
