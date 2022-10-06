package com.jingchu.security.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author 郑彩
 * @Date 2022/10/5 22:26
 * @Version 1.0
 */
@Entity
public class Otp {

    @Id
    private int id;

    private String username;

    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
