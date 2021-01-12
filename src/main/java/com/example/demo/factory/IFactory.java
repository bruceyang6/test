package com.example.demo.factory;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.factory
 * @Description: 抽象工厂类接口
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/14 10:05
 */
public interface IFactory {

    IMask createMsak();

    IProtectSuit createProtectSuit();
}
