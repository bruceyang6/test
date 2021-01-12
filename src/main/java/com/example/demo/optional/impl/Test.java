package com.example.demo.optional.impl;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.optional.impl
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/25 9:48
 */
public class Test {

    int str = 10;
    char[]ch={'x','y','z'};

    public void change(int str, char ch[]){
        str = 100;
        ch[0]='w';
    }
    public static void main(String args[]){
        Test t = new Test();
        t.change(t.str,t.ch);
        System.out.print(t.str+" and ");
        System.out.print(t.ch);}


    /*static int i = 0;
    public int aMethod() {
        i++;
        return i;
    }

    public static void main(String args[]) {
        Test test = new Test();
        test.aMethod();
        int j = test.aMethod();
        System.out.println(j);
        Test test1 = new Test();
        System.out.println(test1.i);
    }*/
}
