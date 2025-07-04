package com.grupo5.MSVisitor.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/visitor")
public class VisitorController {
    @PostMapping("/register")
    public String registerVisitor(@RequestBody Map<String, String> request) {
        String visitorName = request.get("visitorName");
        return "Visitante " + visitorName + " cadastrado com sucesso!";
    }
}