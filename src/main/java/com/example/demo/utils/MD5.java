package com.example.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.utils
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/8/11 15:49
 */
public class MD5 {

    private final static Logger logger = LoggerFactory.getLogger(MD5.class);

    public static String md532(String str) {
        if (str != null) {
            return makemd5(str).toString();
        }else {
            return null;
        }
    }

    public static String md516(String str) {
        if (str != null) {
            return makemd5(str).toString().substring(8, 24);
        }else {
            return null;
        }
    }

    /**
     * 进行MD5加密，返回小写
     * @param str
     * @return
     */
    private static StringBuffer makemd5(String str) {
        StringBuffer buf = new StringBuffer("");
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte b[] = md.digest();
            int i;
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                    buf.append(Integer.toHexString(i));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            logger.error("", e);
        }
        return buf;
    }

    /**
     * 进行MD5加密，并返回大写
     *
     * @param info
     *            要加密的信息
     * @return String 加密后的字符串
     */
    public static String encryptToMD5(String info) {
        byte[] digesta = new byte[0];
        try {
            // 得到一个md5的消息摘要
            MessageDigest alga = MessageDigest.getInstance("MD5");
            // 添加要进行计算摘要的信息
            alga.update(info.getBytes());
            // 得到该摘要
            digesta = alga.digest();
        } catch (NoSuchAlgorithmException e) {
            logger.error("", e);
        }
        // 将摘要转为字符串
        String rs = byte2hex(digesta);
        return rs;
    }

    /**
     * 将二进制转化为16进制字符串
     *
     * @param b
     *            二进制字节数组
     * @return String
     */
    private static String byte2hex(byte[] b) {
        if(b==null) {
            throw new RuntimeException("二进制为空");
        }
        String stmp = "";
        StringBuilder hs = new StringBuilder();
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs.append("0");
                hs.append(stmp);
            } else {
                hs = hs.append(stmp);
            }
        }
        return hs.toString();
    }


    /**
     * 将字符串进行MD5加密，并且指定编码格式
     * 防止不同环境上导致结果不一致
     *
     * @param str
     * @param charsetName
     * @return
     */
    public static String md5ByEncode(String str, String charsetName) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    str.getBytes(charsetName));
        } catch (Exception e) {
            logger.error("", e);
        }
        return new BigInteger(1, secretBytes).toString(16);
    }

    public static String md5ByFile(File file) {
        FileInputStream fis = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            fis = new FileInputStream(file);
            byte[] buffer = new byte[2048];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            logger.error("", e);
            return null;
        } finally {
            try {
                if (fis != null){
                    fis.close();
                }
            } catch (IOException e) {
                logger.error("", e);
            }
        }
    }
}
