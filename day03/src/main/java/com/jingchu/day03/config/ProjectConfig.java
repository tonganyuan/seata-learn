package com.jingchu.day03.config;

import com.jingchu.day03.model.User;
import com.jingchu.day03.service.InMemoryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

/**
 * @Author 郑彩
 * @Date 2022/10/3 20:56
 * @Version 1.0
 */
@Configuration
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService(){

        User user = new User("anyuan", "{noop}1234", "read");

        return new InMemoryUserDetailsService(Collections.singletonList(user));
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
//        return new CustomPasswordEncoder();
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();

    }
}
