package com.grupo5.MSVisitor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/")  // Mapeia a URL raiz
    public String home() {
        return "API Grupo 05 está online!";
    }
}