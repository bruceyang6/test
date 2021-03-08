package com.example.demo.factory.simplefactory;

import com.example.demo.factory.phone;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.factory.simplefactory
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2021/2/25 13:57
 */
public class PhoneFactory {

    public phone.Phone makePhone(String phoneType){
        if(StringUtils.equals(phoneType,"xiaomi")){
            return new phone.MiPhone();
        }else if(StringUtils.equals(phoneType,"phone")){
            return new phone.IPhone();
        }
        return null;
    }
}
