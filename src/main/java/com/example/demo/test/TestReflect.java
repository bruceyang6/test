package com.example.demo.test;

import com.example.demo.test.lombok.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: bruceyang
 * @Description: <一句话描述该类功能/>
 * @Date: Created in 15:17 2022/4/13
 * @Modified By:
 */
public class TestReflect {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test01();
        test02();
        test03();
    }

    public static void test01(){

        User user = new User();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            user.getUsername();
        }
        long endime = System.currentTimeMillis();

        System.out.println("Test01耗时 = " + (endime-startTime) +"ms");
    }


    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        User user = new User();
        Class c1 = user.getClass();
        Method getUsername = c1.getDeclaredMethod("getUsername",null);
//        getUsername.setAccessible(true);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getUsername.invoke(user,null);
        }
        long endime = System.currentTimeMillis();

        System.out.println("Test02耗时 = " + (endime-startTime) +"ms");
    }

    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        User user = new User();
        Class c1 = user.getClass();
        Method getUsername = c1.getDeclaredMethod("getUsername",null);
        getUsername.setAccessible(true);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getUsername.invoke(user,null);
        }
        long endime = System.currentTimeMillis();

        System.out.println("Test03耗时 = " + (endime-startTime) +"ms");
    }

}
