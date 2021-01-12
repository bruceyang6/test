package com.example.demo.factory;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.factory
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/14 10:08
 */
public class HightFactory implements IFactory {
    @Override
    public IMask createMsak() {
        IMask mask = new HightMask();
        return mask;
    }

    @Override
    public IProtectSuit createProtectSuit() {
        IProtectSuit protectSuit = new HightProtectSuit();
        return protectSuit;
    }
}
