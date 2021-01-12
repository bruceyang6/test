package com.example.demo2;

import lombok.Data;

import java.util.Date;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo2
 * @Description: TODO
 * @Dept: 星创产品部
 * @Date: Created in 2020/12/3 13:23
 */
//@Data
public class Member {

    private Integer id;
    private String name;
    private Integer age;
    private Date addDate;

    public Member() {
    }

    public Member(Integer id, String name, Integer age, Date addDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.addDate = addDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", addDate=" + addDate +
                '}';
    }
}
