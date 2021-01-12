package com.example.demo;

public class Animal {

    public Animal(){
        System.out.println("构造函数");
    }

    {
        System.out.println("非静态代码块");
    }

    static {
        System.out.println("静态代码块");
    }

    public void eatGutou(){
        System.out.println("5465465sadf");
    }
    /*public static void main(String[] args) {

        new Animal();
        System.out.println("----------------------------");
//        new Dog();
    }*/

    /**
     * 1.在测类中，new Animal（）；
     * 执行顺序：静态代码块 > 非静态代码块 > 构造函数
     * 2.在测试类中，new Dog（）；
     *执行顺序：静态代码块 > Dog静态代码块 > 非静态代码块 > 构造函数 > Dog非静态代码块 > Dog构造函数
     * 3.在Animal中，new Dog（）；
     * 执行顺序： Dog静态代码块 > 非静态代码块 > 构造函数 > Dog非静态代码块 > Dog构造函数
     * 4.在Animal中，new Animal（）；
     * 执行顺序：同1；
     * 5.在Dog中，new Animal（）；
     * 执行顺序：静态代码块 > Dog静态代码块 > 非静态代码块 > 构造函数
     * 6.在Dog中，new Dog（）；
     *执行顺序：同2；
     *
     * */
}
