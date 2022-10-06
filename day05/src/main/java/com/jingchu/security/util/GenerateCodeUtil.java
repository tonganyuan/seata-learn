package com.jingchu.security.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @Author 郑彩
 * @Date 2022/10/5 22:44
 * @Version 1.0
 */
public class GenerateCodeUtil {

    public static String generateCode() {
        String code;
        try {
            SecureRandom random = SecureRandom.getInstanceStrong();
            int c = random.nextInt(9000)+1000;
            code =  String.valueOf(c);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("error when generate code");
        }

        return code;
    }
}
