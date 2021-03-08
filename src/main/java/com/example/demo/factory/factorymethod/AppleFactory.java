package com.example.demo.factory.factorymethod;

import com.example.demo.factory.phone;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.factory.factorymethod
 * @Description: TODO
 * @Dept: 星创产品部
 * @Date: Created in 2021/2/25 14:23
 */
public class AppleFactory implements PhoneFactory{
    @Override
    public phone.Phone makePhone() {
        return new phone.IPhone();
    }
}
