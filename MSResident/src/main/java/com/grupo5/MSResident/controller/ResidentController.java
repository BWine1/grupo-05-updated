package com.grupo5.MSResident.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/resident")
public class ResidentController {

    @GetMapping("/test")
    public String test() {
        return "MSResident rodando na porta 8081!";
    }
}