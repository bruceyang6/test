package com.example.demo.test;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.test
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2021/1/26 16:25
 */
public class Test20210126 {

    public static void main(final String[] arg) throws Exception {

        for(int i = 1;i<10;i++){
            for(int j = 1;j<=i;j++){
                System.out.print(j+"x"+i+"="+i*j +"\t");
            }
            System.out.println();
        }
    }

}
