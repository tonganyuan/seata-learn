package com.jingchu.security.controller;

import com.jingchu.security.entity.Otp;
import com.jingchu.security.entity.Users;
import com.jingchu.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author 郑彩
 * @Date 2022/10/5 22:53
 * @Version 1.0
 */
@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/add")
    public void addUser(@RequestBody Users user){
        userService.addUser(user);
    }

    @PostMapping("/user/auth")
    public void auth(@RequestBody Users user){
        userService.auth(user);
    }

    @PostMapping("/otp/check")
    public void check(@RequestBody Otp otp, HttpServletResponse response){
        if(userService.check(otp)){
            response.setStatus(HttpServletResponse.SC_OK);
        }else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
