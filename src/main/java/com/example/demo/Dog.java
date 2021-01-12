package com.example.demo;

public class Dog extends Animal {

    public Dog(){
        System.out.println("Dog构造函数");
    }
    {
        System.out.println("Dog非静态代码块");
    }

    static {
        System.out.println("Dog静态代码块");
    }


    public void eat(){
        System.out.println("狗啃骨头");
    }
    public static void main(String[] args) {
//        new Animal();

        System.out.println("--------------");
        new Dog();
    }
}
