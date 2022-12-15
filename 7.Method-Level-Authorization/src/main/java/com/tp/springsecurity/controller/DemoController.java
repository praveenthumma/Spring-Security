package com.tp.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('read')")
    public String hello() {
        return "Helloooooooooooooo!";
    }


    @GetMapping("/hola")
    @PreAuthorize("hasAnyAuthority('read', 'write')")
    public String hola() {
        return "Holaaaaaaaaaaaaaaaa!!";
    }

    @GetMapping("/namaste")
    @PreAuthorize("hasAnyAuthority('read', 'write')")
    public String namaste() {
        return "Namastee!!!!!!!!!!!!!!";
    }
}
