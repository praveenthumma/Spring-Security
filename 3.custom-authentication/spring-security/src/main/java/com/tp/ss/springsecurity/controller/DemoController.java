package com.tp.ss.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    @GetMapping("/hello")
    public String hello() {
        return "<h1>Hello!</h1>";
    }
}
