package com.jingchu.security.auth;

import com.jingchu.security.proxy.AuthenticationServerProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @Author 郑彩
 * @Date 2022/10/6 10:10
 * @Version 1.0
 */
@Component
public class OtpAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AuthenticationServerProxy authenticationServerProxy;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String code = (String) authentication.getCredentials();

        boolean b = authenticationServerProxy.sendOtp(name, code);

        if (b) {
            return new OtpAuthentication(name, code);
        }
        throw new BadCredentialsException("Bad Credential");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return OtpAuthentication.class.isAssignableFrom(authentication);
    }
}
