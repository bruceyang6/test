package com.example.demo.test;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.test
 * @Description: 多态存在的三个必要条件：1.继承 2.重写 3.父类引用指向子类对象
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/15 10:19
 */
public class TestDuoTai {
        public static void main(String[] args) {
            show(new WhiteCat());  // 以 Cat 对象调用 show 方法
            show(new BlackDog());  // 以 Dog 对象调用 show 方法

            Animal a = new WhiteCat();  // 向上转型
            a.eat();               // 调用的是 Cat 的 eat
            WhiteCat c = (WhiteCat)a;        // 向下转型
            c.work();        // 调用的是 Cat 的 work
        }

        public static void show(Animal a)  {
            a.eat();
            // 类型判断
            if (a instanceof WhiteCat)  {  // 猫做的事情
                WhiteCat c = (WhiteCat)a;
                c.work();
            } else if (a instanceof BlackDog) { // 狗做的事情
                BlackDog c = (BlackDog)a;
                c.work();
            }
        }
    }


    abstract class Animal {
        abstract void eat();
    }

    class WhiteCat extends Animal {
        @Override
        public void eat() {
            System.out.println("吃鱼");
        }
        public void work() {
            System.out.println("抓老鼠");
        }
    }

    class BlackDog extends Animal {
        @Override
        public void eat() {
            System.out.println("吃骨头");
        }
        public void work() {
            System.out.println("看家");
        }
    }

