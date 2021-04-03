package com.springldapexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import static java.lang.String.format;

@RestController
@RequestMapping("/api")
public class SpringLdapExampleController {

    @GetMapping("/public")
    public String getPublicString() {
        return "Welcome to the public page!";
    }

    @GetMapping("/private")
    public String getPrivateString(Principal principal) {
        return format("%s, welcome to the private page!", principal.getName());
    }
}
