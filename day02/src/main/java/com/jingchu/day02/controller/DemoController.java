package com.jingchu.day02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 郑彩
 * @Date 2022/10/3 20:50
 * @Version 1.0
 */
@RestController
public class DemoController {

    @GetMapping("hello")
    public String hello(){
        return "Hello Security2";
    }
}
