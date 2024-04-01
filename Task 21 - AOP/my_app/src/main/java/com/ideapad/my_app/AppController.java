package com.ideapad.my_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AppController {

    @Autowired private AppService appService;
    
    @Cacheable("FibonacciCache")
    @GetMapping(path="/api/fibonacci/{number}")
    public Long fibonacci(@PathVariable("number") Long number) {
        return appService.nthFibonacciTerm( number);
    }

    @Cacheable("Pow2Cache")
    @GetMapping(path="/api/pow2/{number}")
    public Long pow2(@PathVariable("number") Long number) {
        return appService.pow2( number);
    }

    @GetMapping("/")
    public String welcomeMsg() {
        return ("Available methods: 1. /api/fibonacci/{number} 2. /api/pow2/{number}");
    }
}
