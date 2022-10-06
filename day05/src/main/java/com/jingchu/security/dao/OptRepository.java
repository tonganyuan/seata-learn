package com.jingchu.security.dao;

import com.jingchu.security.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Author 郑彩
 * @Date 2022/10/5 22:29
 * @Version 1.0
 */
public interface OptRepository extends JpaRepository<Otp,Integer> {

    Optional<Otp> findOtpByUsername(String username);
}
