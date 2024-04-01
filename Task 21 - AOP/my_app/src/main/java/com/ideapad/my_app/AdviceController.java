package com.ideapad.my_app;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AdviceController {
    @Before("execution(* com.ideapad.my_app.AppService.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String params = Arrays.toString(joinPoint.getArgs());
        System.out.println("\nMethod: [" + method + "] called with parameters: " + params);
    }
}