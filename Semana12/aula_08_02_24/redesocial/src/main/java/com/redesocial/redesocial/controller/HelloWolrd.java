package com.redesocial.redesocial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWolrd {

    @RequestMapping("/")
    public String retornMensagem(){
        return "AAAAAAAAAAAAAAAAAAAAAAA";
    }

}
