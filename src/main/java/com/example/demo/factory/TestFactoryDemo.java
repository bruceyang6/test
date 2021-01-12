package com.example.demo.factory;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.factory
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/14 9:52
 */
public class TestFactoryDemo {

    public static void main(String[] args) {

        IFactory factory = new HightFactory();
        IFactory lowEndFactory = new LowEndFactory();

        IMask maskA = factory.createMsak();
        IProtectSuit protectSuitA = factory.createProtectSuit();

        IMask maskB = lowEndFactory.createMsak();
        IProtectSuit protectSuitB = lowEndFactory.createProtectSuit();

        maskA.showMask();
        protectSuitA.showSuit();
        maskB.showMask();
        protectSuitB.showSuit();



    }
}
