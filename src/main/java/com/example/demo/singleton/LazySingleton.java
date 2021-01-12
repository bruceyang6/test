package com.example.demo.singleton;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Description: TODO
 * @Dept: 星创产品部
 * @Date: Created in 2020/7/9 14:52
 */
public class LazySingleton {

        static class SingletonHolder {
            static LazySingleton instance = new LazySingleton();
        }

        public static LazySingleton getInstance() {
            return SingletonHolder.instance;
        }
    }

