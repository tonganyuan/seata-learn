package com.jingchu.day02.config;

import com.jingchu.day02.model.User;
import com.jingchu.day02.service.InMemoryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.List;

/**
 * @Author 郑彩
 * @Date 2022/10/3 20:56
 * @Version 1.0
 */
//@Configuration
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService(){

        User user = new User("anyuan", "1234", "read");

        return new InMemoryUserDetailsService(Collections.singletonList(user));
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
