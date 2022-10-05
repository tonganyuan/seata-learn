package com.jingchu.day03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author 郑彩
 * @Date 2022/10/5 15:55
 * @Version 1.0
 */
@Controller
public class DemoController {

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @PostMapping("/test")
    @ResponseBody
    @CrossOrigin("http://localhost:8080")
    public String test() {
        System.out.println("我被调用了");
        return "Hello jingchu";
    }
}
