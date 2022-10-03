package com.jingchu.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 郑彩
 * @Date 2022/10/1 23:44
 * @Version 1.0
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        return "Hello Security";
    }
}
