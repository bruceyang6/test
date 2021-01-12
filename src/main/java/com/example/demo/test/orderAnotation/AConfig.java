package com.example.demo.test.orderAnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.test.orderAnotation
 * @Description: TODO
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/3 11:07
 */
@Configuration
@Order(value = 1)
public class AConfig {


    @Bean
    public AService excuteAService(){
        System.out.println("true = " + true);
        return new AService();
    }
}
