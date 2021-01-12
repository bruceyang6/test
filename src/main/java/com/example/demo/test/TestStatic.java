package com.example.demo.test;

import com.example.demo.Animal;
import com.example.demo.Dog;

public class TestStatic {

    public static void main(String[] args) {
        new Dog();
    }

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
