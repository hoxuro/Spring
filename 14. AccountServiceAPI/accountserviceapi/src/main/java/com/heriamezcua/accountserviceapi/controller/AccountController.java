package com.heriamezcua.accountserviceapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @RequestMapping("")
    public String getAll(){
        return "Accounts";
    }
}
