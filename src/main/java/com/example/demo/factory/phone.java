package com.example.demo.factory;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.factory
 * @Description: TODO
 * @Dept: 星创产品部
 * @Date: Created in 2021/2/25 14:25
 */
public class phone {
    /**
     * @Author: bruce
     * @Version: V1.0
     * @Package: com.example.demo.factory.simplefactory
     * @Description: TODO
     * @Dept: 星创产品部
     * @Date: Created in 2021/2/25 13:54
     */
    public static class IPhone implements Phone {

        public IPhone(){
            this.make();
        }
        @Override
        public void make() {
            System.out.println("苹果工厂生产苹果手机");
        }
    }

    /**
     * @Author: bruce
     * @Version: V1.0
     * @Package: com.example.demo.factory.simplefactory
     * @Description:
     * @Dept: 星创产品部
     * @Date: Created in 2021/2/25 13:53
     */
    public static class MiPhone implements Phone{
        public MiPhone(){
            this.make();
        }
        @Override
        public void make() {
            System.out.println("小米工厂生产小米手机");
        }
    }

    /**
     * @Author: bruce
     * @Version: V1.0
     * @Package: com.example.demo.factory.simplefactory
     * @Description:
     * @Dept: 星创产品部
     * @Date: Created in 2021/2/25 13:52
     */
    public static interface Phone {
        // 生产手机的抽象方法
        public void make();
    }
}
