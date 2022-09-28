package com.example.demo.test;

import com.example.demo.entity.Person;
import com.example.demo.test.database.DataFactory;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
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

        for (int i = 0; i <= 2; i++) {
            new Thread(

            ).start();
        }

    }
    public static synchronized void  add(){
        System.out.println(" 我是第一个同步锁。。。");
    }

    public static synchronized void  sub(){
        System.out.println(" 我是第二个同步锁。。。");
    }
}
