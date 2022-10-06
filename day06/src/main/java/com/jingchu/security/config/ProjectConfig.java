package com.jingchu.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author 郑彩
 * @Date 2022/10/6 9:37
 * @Version 1.0
 */
@Configuration
public class ProjectConfig{

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
