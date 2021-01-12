package com.example.demo.sortprint;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.sortprint
 * @Description: CountDownLatch测试并发
 * @Dept: 星创产品部
 * @Date: Created in 2020/7/9 15:39
 */
public class ConcurrentCountDownLatchTest {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newCachedThreadPool();
        CountDownLatch cdl = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            CountRunnable runnable = new CountRunnable(cdl);
            pool.execute(runnable);
        }
    }
}

class CountRunnable implements Runnable{
    private CountDownLatch countDownLatch;
    public CountRunnable(CountDownLatch count){
        this.countDownLatch = count;
    }
    @Override
    public void run() {
        try {
            synchronized (countDownLatch){
                countDownLatch.countDown();
                System.out.println("current thread count ="+countDownLatch.getCount());
            }
            countDownLatch.await();
            System.out.println("concurrency counts = "+ (100 - countDownLatch.getCount()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/** CountDownLatch是线程安全的，底层是基于cpu lock cmpxchg的CAS机制（乐观锁），保证对单个变量的读-改-写是原子操作。
 * 这里去掉synchronized (countDownLatch) 会出现重复重复打印的数字是因为countDownLatch.countDown()和
 * countDownLatch.getCount()两个原子操作组合在一起就不是原子操作了，跟CountDownLatch本身没关系。
 * countDownLatch.countDown()之后当前线程ThreadA会释放锁，但还未执行System.out.println("thread counts = "
 * + (countDownLatch.getCount()));，接下来可能被其他线程ThreadB抢到，执行countDownLatch.countDown()操作，
 * 由于底层计数使用的volatile类型，保证了线程间的可见性，所以之后ThreadA和ThreadB同时执行
 * System.out.println("thread counts = " + (countDownLatch.getCount()));就会打印相同的数字。
 加了synchronized (countDownLatch)后，countDownLatch.countDown()和countDownLatch.getCount()被人为原子化了，
 所以不会出现数据竞争，结果是正确的 */