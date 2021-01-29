package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2021/1/29 9:41
 */
@SpringBootApplication(scanBasePackages = "com.example")
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }
}
