package com.heriamezcua.accountserviceapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @RequestMapping("")
    public String getAll() {
        return "Customers";
    }
}