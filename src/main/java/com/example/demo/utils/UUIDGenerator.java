package com.example.demo.utils;

import java.util.UUID;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.utils
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/8/11 15:43
 */
public class UUIDGenerator {
    private static UUIDGenerator uniqueInstance = new UUIDGenerator();;

    private UUIDGenerator() {
    }

    public static UUIDGenerator getInstance() {

        return uniqueInstance;

    }
    /**
     * 获取原始生成的UUID未加密
     *
     * @return str 返回原始UUID
     */
    public String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str.toUpperCase();
    }

    /**
     * 获取去掉"-"后生成的16位UUID并MD5加密
     *
     * @return str 返回原始UUID
     */
    public String getReplaceUUID() {
//		UUID uuid = UUID.randomUUID();
//		String str = uuid.toString();
        // 去掉"-"符号
        String temp = getUUID().replace("-", "");
        temp = MD5.md516(temp);
        return temp.toUpperCase();
    }

    /**
     * 获得原始生成指定数量的UUID未加密
     *
     * @return str 返回原始UUID
     */
    public String[] getUUIDByNum(int number) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID();
        }
        return ss;
    }

    /**
     * 获得去掉"-"后生成指定数量的UUID未加密
     *
     * @return str 返回原始UUID
     */
    public String[] getReplaceUUIDByNum(int number) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID().replace("-", "");
        }
        return ss;
    }

    /**
     * 获取去掉"-"后生成的32位UUID并MD5加密
     *
     * @return str 返回原始UUID
     */
    public String getReplaceUUIDTo32() {
//		UUID uuid = UUID.randomUUID();
//		String str = uuid.toString();
        // 去掉"-"符号
        String temp = getUUID().replace("-", "");
        temp = MD5.md532(temp);
        return temp.toUpperCase();
    }

    private String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };

    /**
     * 获取去掉"-"后生成的8位UUID
     * @return
     */
    public String getReplaceShortUUID() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = getUUID().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();

    }

}
