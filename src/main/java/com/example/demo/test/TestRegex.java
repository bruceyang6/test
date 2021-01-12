package com.example.demo.test;

import com.example.demo.Dog;
import com.example.demo.utils.RegularValidata;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.test
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/1 17:13
 */
public class TestRegex {

    public static void main(String[] args)throws Exception {

        /*char[] arr1 = {'a','b','c'};
        char[] arr2 = {'e','f','g'};
        char[] arr3 = new char[6];
        System.arraycopy(arr1,0,arr3,0,arr1.length);
        System.arraycopy(arr2,0,arr3,arr1.length,arr2.length);*/

        /*int x = 0, y = 0;
        do {
            if (x % 3 == 0) {
                x++;
                continue;
            }
            x++;
            y = y + x;
        } while (x < 4);
        System.out.println(y);*/


        /*int [] arr = {1,3,4};
        String str = "[";
        for (int x=0; x<2 ; x++){
            if(x!=2) {
                System.out.println("x = " + x+";arr.length =" +(arr.length-1));
                str = str + arr[x] + ",";
            }else {
                System.out.println("x = " + x+";arr.length =" +arr.length);
                str = str + arr[x] + "]";
            }
        }
        System.out.println("str = " + str);*/

        boolean matches = Pattern.matches("^(((13[0-9])|(15[^4])|(166)|(17[0-8])|(18[0-9])|(19[0-9])|(147,145))\\d{8})?$", "");
        System.out.println("matches = " + matches);

        /*BigDecimal bigDecimal1 = new BigDecimal("8.89");
        BigDecimal bigDecimal2 = new BigDecimal(bigDecimal1.intValue());
        BigDecimal bigDecimal3 = new BigDecimal(bigDecimal1.toBigInteger());
        if(bigDecimal1.compareTo(bigDecimal2) == 0){
            System.out.println("相等 = " + bigDecimal3);
        }*/
//        -_－—
        //(([1][3-9][\\d]{9})|(0\\d{2,4}-\\d{7,8})) | (^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$*)
        String ss = null;
        Integer integer = 88;
        if(!Pattern.matches("^[0-9]*$",ss)){
            throw new Exception("args = " + "不合适");
        }

        String s2 = "123465465465461";
        if(!validataAreaId(s2)) {
            throw new Exception("【地址编号】只能是数字！");
        }
        String[] strings = splitPointNum("100");
        if (Integer.valueOf(strings[1]) != 0) {
            throw new Exception("【货物件数】不支持小数！");
        }

        //截取小数，整数部分和小数部分方法
        String as = "30.12";
        int point = as.indexOf(".");
        System.out.println(as +"的整数："+as.substring(0, point) +",小数："+as.substring(point+1,as.length()));
        Integer integer1 = Integer.valueOf(as.substring(point + 1, as.length()));
        Double d1 = Double.valueOf(as);
        Double d2 = Double.valueOf(as.substring(0, point));
        Double value = d1 - d2;
        Double dd = (double) Math.round(value*100)/100;//double保留两位小数

        System.out.println("value = " + dd);
        if(integer1 != 0){
            System.err.println("不支持小数 = " + integer1);
        }


        //字符串，没有截取小数整数，和小数的方法
        String s = "1234.5612";
        int i1 = s.indexOf(".") + 1;
        int length = s.length();
        String substring = s.substring(i1, length);
        int length1 = substring.length();
        System.out.println("length1 = " + length1);
        /*int i1 = s.indexOf(".");//若存在，则显示该字符的下标，否则，-1；
        System.out.println("i1 = " + i1);*/
        int i = s.lastIndexOf(".");
        BigDecimal bigDecimal = new BigDecimal("12.1");
        double d12 = Double.parseDouble(bigDecimal.toString());
        long m = (long)d12;
        double random = Math.round((d12 - m)*100);
        Integer integer2 = Integer.valueOf(((long) random) + "");
        System.out.println("integer2 = " + integer2);
        /*double pow = Math.pow(10, 2);//次方
        System.out.println("pow = " + pow);*/


//        "^\\d$|(\\d+(\\.\\d{0,2})?$)"
//        String rex = "^\\d$|(\\d+(\\.\\d{0,2})?$)";
//        String rex = "^.{6,20}";//6-20位字符；
//        String rex = "^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$";
//        String input = "0.1";
//        if(!Pattern.matches(rex,input)) {
//            System.out.println("验证不通过 = " + "请输入正确值(整数位不超过5位，小数位不超过两位)！");
//
//        }
        /*boolean b = RegularValidata.validataBigdecimal(132467819.00);
        if(!b){
            throw new RuntimeException("bigdecimal类型不对");
        }*/
        /*String rex = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？A-Za-z0-9]{6}";
        String input = "123";
        if(!Pattern.matches(rex,input)) {
            System.out.println("验证不通过 = " + "请输入正确值(6位字符)！");

        }*/
        // [`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？A-Za-z0-9]
        // /^[+]{0,1}(\d+)$|[+]{0,1}(\d+\.\d+)$/
        // /^[+]{0,1}(\d+)$/
        /*String rex = "^\\d{1,5}$|^\\d{1,5}+(.[0]{1,2})?$";
        String input = "12345.00";
        if(!Pattern.matches(rex,input)) {
            System.out.println("验证不通过 = " + "请输入正确值(整数位不超过5位，小数位不超过两位)！");

        }*/
        /*String rex = "^\\d{1,6}$|^\\d{1,6}+(.[0-9]{1,2})?$";
        String input = "2.01";
        if(!Pattern.matches(rex,input)) {
            System.out.println("验证不通过 = " + "请输入正确值(整数位不超过6位，小数位不超过两位)！");

        }*/
    }

    
    public static boolean validataAreaId(Object obj) {
        boolean flag = false;
        try {
            if (obj != null) {
                String source = new BigDecimal(obj.toString()).toString();
                // 判断是否是整数或者是携带一位或者两位的小数
                Pattern pattern = Pattern.compile("^[0-9]*$");
                if (pattern.matcher(source).matches()) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return flag;
    }

    /**
     * @Author: bruce
     * @Description: 将小数拆分，返回整数和小数
     * @Param:
     * @return:
     * @Date: 2020/9/21 11:33
     */
    public static String[] splitPointNum(String pointNum){

        String[] arrStr = new String[2];
        String fNum;
        if(StringUtils.isBlank(pointNum)){
            return null;
        }
        int point = pointNum.indexOf(".");
        if(point != -1){
            fNum = pointNum.substring(0, point);
            arrStr[0] = fNum;
            String aNum = pointNum.substring(point + 1, pointNum.length());
            arrStr[1] = aNum;
        }else {
            arrStr[0] = pointNum;
            arrStr[1] = "0";
        }
        return arrStr;
    }
    
    public static class Aoo{
        int num;
        Aoo(int num){
            this.num = num;
        }
    }
}
