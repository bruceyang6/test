package com.example.demo.test.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
//import sun.text.bidi.BidiLine;

import java.util.List;

/**
 * @Author: bruceyang
 * @Description: <一句话描述该类功能/>
 * @Date: Created in 14:13 2021/12/8
 * @Modified By:
 */
//@Builder

public class User {

    private Long id;
    private String username;
    private String password;
    //    @Singular(value = "testHobby")
    private List<String> hobby;

    public User() {

    }
    public User(Long id,String username){
        this.id = id;
        this.username = username;
    }

    public User(Long id, String username, String password, List<String> hobby) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.hobby = hobby;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", hobby=" + hobby +
                '}';
    }

}
