package com.jingchu.oauth2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

/**
 * @Author 郑彩
 * @Date 2022/10/7 10:43
 * @Version 1.0
 */
@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public ClientRegistrationRepository clientRegistrationRepository(){
        ClientRegistration clientRegistration = clientRegistration();
        return new InMemoryClientRegistrationRepository(clientRegistration);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login();

        http.authorizeRequests().anyRequest().authenticated();
    }

    private ClientRegistration clientRegistration(){
        return CommonOAuth2Provider.GITHUB.getBuilder("github")
                .clientId("a4348e22832b524aca27")
                .clientSecret("ff3540193310713d6c594bcad8b044583f28f352").build();
    }
}
