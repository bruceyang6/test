package com.example.demo.factory;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.factory
 * @Description: 低端口罩实现类
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/14 9:54
 */
public class LowEndMask implements IMask {
    @Override
    public void showMask() {
        System.out.println("我是低端口罩类。。。LowEndMask");
    }
}
