package com.ideapad.my_app;

import org.springframework.stereotype.Service;

@Service
public class AppService {
    public Long nthFibonacciTerm(Long n){
        if(n == 1 || n == 0){
            return n;
        }
        return nthFibonacciTerm(n-1) + nthFibonacciTerm(n-2);
    }

    public Long pow2(Long n){
        return n * n;
    }
}
