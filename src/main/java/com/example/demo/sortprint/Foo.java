package com.example.demo.sortprint;

import java.util.concurrent.CountDownLatch;

/**
 *
 *我们提供了一个类: .
 * public class Foo {
 * public void one() { print("one"); }
 * public void two() { print("two"); }
 * public void three() { print("three"); }
 * 三个不同的线程将会共用一个Foo实例。
 * ●线程A将会调用one() 方法
 * ●线程B将会调用two() 方法
 * ●线程C将会调用three() 方法
 * 请设计修改程序，以确保two() 方法在one() 方法之后被执行，three() 方法在two() 方
 * 法之后被执行。
 *
 * CountDownLatch的用法
 *
 * 某一线程在开始运行前等待n个线程执行完毕。将CountDownLatch的计数器初始化为new CountDownLatch(n)，每当一个任务线程执行完毕，
 * 就将计数器减1，当计数器的值变为0时，在CountDownLatch上await()的线程就会被唤醒。一个典型应用场景就是启动一个服务时，主线程
 * 需要等待多个组件加载完毕，之后再继续执行。
 *
 * 实现多个线程开始执行任务的最大并行性。注意是并行性，不是并发，强调的是多个线程在某一时刻同时开始执行。类似于赛跑，将多个线程
 * 放到起点，等待发令枪响，然后同时开跑。做法是初始化一个共享的CountDownLatch(1)，将其计算器初始化为1，多个线程在开始执行任务
 * 前首先countdownlatch.await()，当主线程调用countDown()时，计数器变为0，多个线程同时被唤醒。
 *
 */
public class Foo {

    private CountDownLatch second = new CountDownLatch(1);
    private CountDownLatch third = new CountDownLatch(1);

    public Foo(){}

    public void one(){
        System.out.println("one");
    }
    public void two(){
        System.out.println("two");
    }
    public void three(){
        System.out.println("three");
    }

    public void first(Runnable printFirst){
        printFirst.run();
        second.countDown();
    }
    public void second(Runnable printSecond) throws InterruptedException {
        second.await();
        printSecond.run();
        third.countDown();
    }
    public void third(Runnable printThird) throws InterruptedException {
        third.await();
        printThird.run();

    }
}
