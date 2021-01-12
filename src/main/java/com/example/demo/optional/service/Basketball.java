package com.example.demo.optional.service;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.optional.service
 * @Description: TODO
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/25 9:38
 */
public class Basketball implements Ball {

    int k = 20;

    public static void main(String[] args) {
        Ball ball = new Basketball();
        int k = ball.k;
        System.out.println(k);
    }

    /*
    * 多态中的成员变量。 Java中，成员变量是没有重写的，成员变量不可以被继承或覆盖，即不能实现多态。
    *  只有方法才能构成多态。也就是说方法可以实现动态绑定，而变量用于是静态绑定。
    * */
}
