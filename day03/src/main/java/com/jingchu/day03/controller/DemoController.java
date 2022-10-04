package com.jingchu.day03.controller;

import org.springframework.security.concurrent.DelegatingSecurityContextCallable;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutor;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutorService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

/**
 * @Author 郑彩
 * @Date 2022/10/3 20:50
 * @Version 1.0
 */
@RestController
public class DemoController {

    @GetMapping("hello")
    public String hello() throws ExecutionException, InterruptedException {

        Callable<String> callable = () ->{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return authentication.getName();
        };
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        try {
//            DelegatingSecurityContextCallable<String> securityContextCallable = new DelegatingSecurityContextCallable<>(callable);
//            String name = executorService.submit(securityContextCallable).get();
//            return "Hello " + name;
//        } finally {
//            executorService.shutdown();
//        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        DelegatingSecurityContextExecutorService executorService1 = new DelegatingSecurityContextExecutorService(executorService);
        String name = executorService1.submit(callable).get();
        return "Hello " + name;


    }
}
