package com.grupo5.MSAccessControl.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo5.MSAccessControl.dto.AuthorizationDTO;
import com.grupo5.MSAccessControl.service.AuthorizationService;

@RestController
@RequestMapping("/authorization")
public class AuthorizationController {
    private final AuthorizationService authorizationService;

    public AuthorizationController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @GetMapping
    public List<AuthorizationDTO> getAll() {
        return authorizationService.findAll();
    }

    @GetMapping("/{id}")
    public AuthorizationDTO getById(@PathVariable Long id) {
        return authorizationService.findById(id).orElseThrow(() -> new RuntimeException("Authorization não encontrada"));
    }

    @PostMapping
    public AuthorizationDTO create(@RequestBody AuthorizationDTO dto) {
        return authorizationService.save(dto);
    }

    @PutMapping("/{id}")
    public AuthorizationDTO update(@PathVariable Long id, @RequestBody AuthorizationDTO dto) {
        return authorizationService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorizationService.delete(id);
    }
} 