package com.grupo5.MSVisitor.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo5.MSVisitor.dto.CompanyDTO;
import com.grupo5.MSVisitor.model.Company;
import com.grupo5.MSVisitor.repository.CompanyRepository;

@RestController
@RequestMapping("/empresa")
public class CompanyController {
    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public List<CompanyDTO> listarTodas() {
        return companyRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CompanyDTO buscarPorId(@PathVariable Long id) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
        return toDTO(company);
    }

    @PostMapping
    public CompanyDTO criar(@RequestBody CompanyDTO dto) {
        Company company = new Company();
        company.setName(dto.getName());
        company.setCnpj(dto.getCnpj());
        Company saved = companyRepository.save(company);
        return toDTO(saved);
    }

    @PutMapping("/{id}")
    public CompanyDTO atualizar(@PathVariable Long id, @RequestBody CompanyDTO dto) {
        Company existente = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
        existente.setName(dto.getName());
        existente.setCnpj(dto.getCnpj());
        Company saved = companyRepository.save(existente);
        return toDTO(saved);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        companyRepository.deleteById(id);
    }

    private CompanyDTO toDTO(Company company) {
        CompanyDTO dto = new CompanyDTO();
        dto.setId(company.getId());
        dto.setName(company.getName());
        dto.setCnpj(company.getCnpj());
        return dto;
    }
} 