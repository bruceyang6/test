package com.example.demo.test;

import java.util.HashMap;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/7/13 12:13
 */
public class TestHashCode {

    public static void main(String[] args) {
        Person p1 = new Person("zhangsan");
        Person p2 = new Person("zhangsan");

        HashMap<Person, Integer> map = new HashMap<>();
        map.put(p1,1);

        System.out.println(p1.equals(p2));
        System.out.println(map.containsKey(p2));

        boolean[] set = new boolean[26];
        System.out.println("set = " + set.toString());
    }

    static class Person{
        private String name;
        public Person(){}
        public Person(String name){
            this.name=name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Person){
                Person p = (Person) obj;
                return name.equals(p.name);
            }
            return false;
        }
        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }
}
