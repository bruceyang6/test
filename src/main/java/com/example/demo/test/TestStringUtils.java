package com.example.demo.test;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.test
 * @Description: TODO
 * @Dept: 星创产品部
 * @Date: Created in 2020/12/3 16:14
 */
public class TestStringUtils {

    public static void main(String[] args) {

        /**
         * @Author: bruce
         * @Description: 测试StringUtils中的部分方法
         * @Param: [args]
         * @return: void
         * @Date:
         */
        /** 6789 截取第五个字符之后的串（不包含第五位）*/
        String sub = StringUtils.substring("123456789", 5);
        /** 67 截取第五个字符到第七个字符 （索引从0开始）*/
        String substring = StringUtils.substring("123456789", 5,7);
        /** 123 截取从左起三位*/
        String left = StringUtils.left("123456789", 3);
        /** 789 截取从右起三位 */
        String right = StringUtils.right("123456789", 3);
        /** 用*从左边补齐，共10位  (*******123)*/
        String leftPad = StringUtils.leftPad("123", 10, "*");
        /** 用*从右边补齐，共10位  (123*******)*/
        String rightPad = StringUtils.rightPad("123", 10, "*");
        /** 用*从两边补齐，共10位  (***123****)*/
        String center = StringUtils.center("123", 10, "*");
        /** 移除开始对应的字符  456 */
        String removeStart = StringUtils.removeStart("123456", "123");
        /** 移除结尾对应的字符 123 */
        String removeEnd = StringUtils.removeEnd("123456", "456");
        /** 6789123******* 拼接字符串 */
        String concat = sub.concat(rightPad);

    }
}
