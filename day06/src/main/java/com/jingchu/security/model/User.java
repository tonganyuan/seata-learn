package com.jingchu.security.model;

/**
 * @Author 郑彩
 * @Date 2022/10/6 9:35
 * @Version 1.0
 */
public class User {

    private int id;

    private String username;

    private String password;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
