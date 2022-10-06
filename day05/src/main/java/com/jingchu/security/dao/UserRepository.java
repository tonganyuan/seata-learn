package com.jingchu.security.dao;

import com.jingchu.security.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Author 郑彩
 * @Date 2022/10/5 22:27
 * @Version 1.0
 */
public interface UserRepository extends JpaRepository<Users,Integer> {

    Optional<Users> findUserByUsername(String username);
}
