package com.example.demo.test;

import com.example.demo.entity.Salary;
import com.example.demo.entity.Employee;

import java.math.BigDecimal;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.test
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/15 10:36
 */
public class VirtualDemo {
    public static void main(String [] args) {
        Salary s = new Salary("员工 A", "北京", 3, 3600.00);
        Employee e = new Salary("员工 B", "上海", 2,2400.00);

        System.out.println("使用 Salary 的引用调用 mailCheck -- ");
        s.mailCheck();
        System.out.println("\n使用 Employee 的引用调用 mailCheck--");
        e.mailCheck();

        double pow = Math.pow(2, 31)-1; //2147483647
        double pow1 = -Math.pow(2, 31); //-2147483648
        String s_ = new BigDecimal(pow1).toPlainString();
        Integer decode = Integer.decode(s_);
        System.out.println("value = " + decode);
        String password = s.getPassword();
        System.out.println("password = " + password);


        /**
         * @Description: 特别地
         * @Date: 2020/9/15 11:16
         */
        //1.若父类想调用子类特有（父类没有）方法，则需向下转型
        /*Salary s1 = (Salary) e;
        s1.computePay();*/   //父类向下转型后，调用子类特有方法

        //2.通过匿名内部类的方式，父类调用子类的特有方法
        /*new Employee(){
            public void computePay(){
            System.out.println("computePay-----");
        }}.computePay();*/
        /**方法1 和 2 比较：
         * 当已经定义了一个子类时，我们常用强转方法:
             * （1）父类强转子类后，可多次调用子类的方法
             * （2）可灵活调用子类各种特有方法
         * 当我们没有定义好一个子类时，也不想去定义这个子类，只想临时用一下，可以采用匿名内部类对象方法:
             * （1）省去了定义子类的过程
             * （2）较适合临时性，突发性，想调用一个特有方法时
             * （3）他想多次调用一个特有方法时，没有1方便
         */
    }
}
