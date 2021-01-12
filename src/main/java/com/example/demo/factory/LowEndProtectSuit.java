package com.example.demo.factory;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.factory
 * @Description: 低端防护服实现类
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/14 10:02
 */
public class LowEndProtectSuit implements IProtectSuit {
    @Override
    public void showSuit() {
        System.out.println("我是低端防护服类。。。LowEndProtectSuit");
    }
}
