package com.example.demo.entity;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.entity
 * @Description: TODO
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/15 10:34
 */
public class Employee {
    private String name;
    private String address;
    private int number;
    public Employee(String name, String address, int number) {
        System.out.println("Employee 构造函数");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public Employee() {

    }

    public void mailCheck() {
        System.out.println("Employee 类的 mailCheck 方法");
        System.out.println("邮寄支票给： " + this.name
                + " " + this.address);
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String newAddress) {
        address = newAddress;
    }
    public int getNumber() {
        return number;
    }
    @Override
    public String toString() {
        return name + " " + address + " " + number;
    }
}
