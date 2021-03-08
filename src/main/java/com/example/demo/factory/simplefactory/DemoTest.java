package com.example.demo.factory.simplefactory;

import com.example.demo.factory.phone;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.factory.simplefactory
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2021/2/25 13:59
 */
public class DemoTest {

    public static void main(String[] args) {
        PhoneFactory pf = new PhoneFactory();
        phone.Phone xiaomi = pf.makePhone("xiaomi");
        phone.Phone phone = pf.makePhone("phone");
    }
}
