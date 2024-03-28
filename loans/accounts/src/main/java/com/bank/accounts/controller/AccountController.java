package com.bank.accounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AccountsController {

    @GetMapping("sayHello")
    public String sayHello(){
        return "<h1>hi dfsdfd there World</h1>";
    }
}