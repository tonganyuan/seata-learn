package com.jingchu.security.filter;

import com.jingchu.security.auth.OtpAuthentication;
import com.jingchu.security.auth.UsernamePasswordAuthentication;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 郑彩
 * @Date 2022/10/6 11:32
 * @Version 1.0
 */
@Component
public class InitialAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Value("${jwt.signing.key}")
    private String signingKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String username = request.getHeader("username");
        String password = request.getHeader("password");
        String code = request.getHeader("code");
        if(code == null){
            UsernamePasswordAuthentication usernamePasswordAuthentication = new UsernamePasswordAuthentication(username, password);
            authenticationManager.authenticate(usernamePasswordAuthentication);
        }else {
            OtpAuthentication otpAuthentication = new OtpAuthentication(username, code);
            authenticationManager.authenticate(otpAuthentication);

            SecretKey secretKey = Keys.hmacShaKeyFor(signingKey.getBytes(StandardCharsets.UTF_8));

            Map<String, String> map = new HashMap<>();
            map.put("username",username);
            String jwt = Jwts.builder().setClaims(map)
                    .signWith(secretKey).compact();
            response.setHeader("Authorization",jwt);

        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getServletPath().equals("/login");
    }
}
