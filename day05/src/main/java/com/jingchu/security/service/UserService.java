package com.jingchu.security.service;

import com.jingchu.security.dao.OptRepository;
import com.jingchu.security.dao.UserRepository;
import com.jingchu.security.entity.Otp;
import com.jingchu.security.entity.Users;
import com.jingchu.security.util.GenerateCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * @Author 郑彩
 * @Date 2022/10/5 22:30
 * @Version 1.0
 */
@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OptRepository optRepository;

    @Transactional(rollbackFor = Exception.class)
    public void addUser(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public void auth(Users user){
        Optional<Users> result = userRepository.findUserByUsername(user.getUsername());
        if(result.isPresent()){
            Users u = result.get();
            if(passwordEncoder.matches(user.getPassword(),u.getPassword())){
                renewOtp(u);
                return;
            }
        }
        throw new BadCredentialsException("无效的凭据："+user.getUsername());
    }

    public boolean check(Otp otp){
        Optional<Otp> otpByUsername = optRepository.findOtpByUsername(otp.getUsername());
        if(otpByUsername.isPresent()){
            Otp otp1 = otpByUsername.get();
            return otp1.getCode().equals(otp.getCode());
        }
        return false;
    }

    private void renewOtp(Users u) {
        String code = GenerateCodeUtil.generateCode();

        Optional<Otp> otpByUsername = optRepository.findOtpByUsername(u.getUsername());
        if(otpByUsername.isPresent()){
            Otp otp = otpByUsername.get();
            otp.setCode(code);
        }else{
            Otp otp = new Otp();
            otp.setUsername(u.getUsername());
            otp.setCode(code);
            optRepository.save(otp);
        }

    }

}
