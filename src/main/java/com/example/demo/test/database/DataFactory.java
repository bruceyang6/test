package com.example.demo.test.database;

import com.example.demo.entity.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.test.database
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/12/10 9:56
 */
public class DataFactory {

    public static List<Person> getPersonList(){
        List<Person> list = new ArrayList();
        list.add(new Person("1","张三",18,"女"));
        list.add(new Person("2","李四",15,"男"));
        list.add(new Person("3","华罗庚",19,"女"));
        list.add(new Person("4","李时珍",16,"男"));
        list.add(new Person("5","司马光",12,"男"));
        list.add(new Person("6","司马懿",19,"男"));
        return list;
    }

}
