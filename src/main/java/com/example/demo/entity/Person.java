package com.example.demo.entity;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.entity
 * @Description: TODO
 * @Dept: 星创产品部
 * @Date: Created in 2020/12/10 9:54
 */
public class Person {

    private String id;
    private String name;
    private Integer age;
    private String gender;

    public Person(String id, String name, Integer age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
