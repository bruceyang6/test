package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Students {


    /** id */
    private Long id;
    /** 姓名 */
    private String name;
    /** 性别 */
    private String gender;
    /** 年龄 */
    private Integer age;
    /** 年级 */
    private String grade;
    /** 出生年月 */
    private Date birthday;

    private Double tuitioin;

    /** 书本费 */
    private BigDecimal bookAmount;

    public Students(){}

    public Students(Long id, String name, String gender, Integer age, String grade, Date birthday,Double tuition,BigDecimal bookAmount) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.grade = grade;
        this.birthday = birthday;
        this.tuitioin = tuition;
        this.bookAmount = bookAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getTuitioin() {
        return tuitioin;
    }

    public void setTuitioin(Double tuitioin) {
        this.tuitioin = tuitioin;
    }

    public BigDecimal getBookAmount() {
        return bookAmount;
    }

    public void setBookAmount(BigDecimal bookAmount) {
        this.bookAmount = bookAmount;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", birthday=" + birthday +
                ", tuitioin=" + tuitioin +
                '}';
    }
}
