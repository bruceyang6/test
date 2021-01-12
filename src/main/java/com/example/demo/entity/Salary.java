package com.example.demo.entity;

import javax.swing.*;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.entity
 * @Description: TODO
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/15 10:35
 */
public class Salary extends Employee
{

    // 全年工资
    private double salary;
    public Salary(String name, String address, int number, double salary) {
        super(name, address, number);
        setSalary(salary);
    }
    @Override
    public void mailCheck() {
        System.out.println("Salary 类的 mailCheck 方法 ");
        System.out.println("邮寄支票给：" + getName()
                + " ，工资为：" + salary);
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double newSalary) {
        if(newSalary >= 0.0) {
            salary = newSalary;
        }
    }
    public double computePay() {
        System.out.println("计算工资，付给：" + getName());
        return salary/52;
    }

    public String getPassword(){

        JPasswordField pf = new JPasswordField();
        char ch = 'a';
        char[] password = pf.getPassword();
        if(password == null){
            System.out.println("null = " + null);
        }
        if( password.length == 0){
            password = new char[]{'y', 'a','n', 'g','l', 'e','e','@','_'};
            System.out.println("password.length = " + password.length);
        }
        String s = new String(password);
        return s;
    }
}
