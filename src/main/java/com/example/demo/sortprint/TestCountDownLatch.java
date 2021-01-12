package com.example.demo.sortprint;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Description: TODO
 * @Dept: 星创产品部
 * @Date: Created in 2020/7/9 14:07
 */
@Slf4j
public class TestCountDownLatch {

    public static void main(String[] args) {
       final CountDownLatch latch = new CountDownLatch(2);

        System.out.println("主线程开始执行 。。。 。。。");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("子线程："+Thread.currentThread().getName()+"执行");
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
                latch.countDown();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("子线程："+Thread.currentThread().getName()+"执行");
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
                latch.countDown();
            }
        });
        t1.start();
        t2.start();
        System.out.println("等待两个线程执行完毕。。。。。。。");
        try {
            latch.await();
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        System.out.println("两个线程都执行完毕，继续执行主线程。。。");
    }
}
