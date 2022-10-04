package com.jingchu.day03.config;

import com.jingchu.day03.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author 郑彩
 * @Date 2022/10/4 15:15
 * @Version 1.0
 */
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return hashWithSHA512(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return hashWithSHA512(rawPassword.toString()).equals(encodedPassword);
    }

    private String hashWithSHA512(String input){
        StringBuilder result = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] digest = md.digest(input.getBytes());
            for (int i = 0; i < digest.length; i++) {
                result.append(Integer.toHexString(digest[i]));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result.toString();

    }

}
