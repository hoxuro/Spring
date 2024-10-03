package com.myshoppingcart.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @RequestMapping(value = "/usuarios")
    public String name() {
        return "Usuarios";
    }

}
