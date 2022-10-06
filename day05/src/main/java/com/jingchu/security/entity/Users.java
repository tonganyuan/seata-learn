package com.jingchu.security.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author 郑彩
 * @Date 2022/10/5 22:25
 * @Version 1.0
 */
@Entity
public class Users {

    @Id
    private int id;

    private String username;

    private String password;

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
