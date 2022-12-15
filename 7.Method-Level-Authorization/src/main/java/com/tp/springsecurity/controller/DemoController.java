package com.tp.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('read')")
    public String demo() {
        return "Helloooooooooooooo!";
    }
}
