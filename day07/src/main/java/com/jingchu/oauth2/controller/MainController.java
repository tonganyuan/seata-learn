package com.jingchu.oauth2.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author 郑彩
 * @Date 2022/10/6 21:53
 * @Version 1.0
 */
@Controller
public class MainController {

    @GetMapping("/")
    public String main(OAuth2AuthenticationToken token) {
        System.out.println(token);
        return "main.html";
    }
}
