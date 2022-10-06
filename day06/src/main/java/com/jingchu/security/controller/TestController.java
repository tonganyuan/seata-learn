package com.jingchu.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 郑彩
 * @Date 2022/10/5 23:07
 * @Version 1.0
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return "Test" + authentication.getName();
    }
}
