package com.example.demo.factory.factorymethod;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.factory.factorymethod
 * @Description: TODO
 * @Dept: 星创产品部
 * @Date: Created in 2021/2/25 14:24
 */
public class DemoTest {

    public static void main(String[] args) {
        XiaomiFactory xf = new XiaomiFactory();
        PhoneFactory pf = new AppleFactory();
        xf.makePhone();
        pf.makePhone();
    }
}
