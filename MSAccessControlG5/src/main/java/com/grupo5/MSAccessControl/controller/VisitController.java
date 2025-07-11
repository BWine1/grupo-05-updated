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

import com.grupo5.MSAccessControl.dto.VisitDTO;
import com.grupo5.MSAccessControl.service.VisitService;

@RestController
@RequestMapping("/visit")
public class VisitController {
    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping
    public List<VisitDTO> getAll() {
        return visitService.findAll();
    }

    @GetMapping("/{id}")
    public VisitDTO getById(@PathVariable Long id) {
        return visitService.findById(id).orElseThrow(() -> new RuntimeException("Visit não encontrada"));
    }

    @PostMapping
    public VisitDTO create(@RequestBody VisitDTO dto) {
        return visitService.save(dto);
    }

    @PutMapping("/{id}")
    public VisitDTO update(@PathVariable Long id, @RequestBody VisitDTO dto) {
        return visitService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        visitService.delete(id);
    }
} 