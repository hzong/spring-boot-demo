package com.example.hz.demospringboot.pojo.dto;

/**
 * @Classname User
 * @Description TODO
 * @Date 2019-03-05 00:15
 * @Created by hzong
 */
public class User {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

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
}
