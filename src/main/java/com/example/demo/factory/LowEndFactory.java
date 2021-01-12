package com.example.demo.factory;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.factory
 * @Description: 低端工厂实现类
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/14 10:06
 */
public class LowEndFactory implements IFactory {
    @Override
    public IMask createMsak() {
        IMask mask = new LowEndMask();
        return mask;
    }

    @Override
    public IProtectSuit createProtectSuit() {
        IProtectSuit protectSuit = new LowEndProtectSuit();
        return protectSuit;
    }
}
