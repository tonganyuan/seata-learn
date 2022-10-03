package com.jingchu.day02.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 郑彩
 * @Date 2022/10/3 20:53
 * @Version 1.0
 */
public class InMemoryUserDetailsService implements UserDetailsService {

    private List<UserDetails> userList;

    public InMemoryUserDetailsService(List<UserDetails> userList) {
        this.userList = userList;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userList.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("user name or password is not avalid"));
    }
}
