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

import com.grupo5.MSVisitor.dto.VisitorDTO;
import com.grupo5.MSVisitor.dto.VisitorMapper;
import com.grupo5.MSVisitor.model.Company;
import com.grupo5.MSVisitor.model.Visitor;
import com.grupo5.MSVisitor.repository.CompanyRepository;
import com.grupo5.MSVisitor.repository.VisitorRepository;

@RestController
@RequestMapping("/visitante")
public class VisitorController {
    private final VisitorRepository visitorRepository;
    private final CompanyRepository companyRepository;

    public VisitorController(VisitorRepository visitorRepository, CompanyRepository companyRepository) {
        this.visitorRepository = visitorRepository;
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public List<VisitorDTO> listarTodos() {
        return visitorRepository.findAll().stream()
                .map(VisitorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public VisitorDTO buscarPorId(@PathVariable Long id) {
        Visitor visitor = visitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Visitor não encontrado"));
        return VisitorMapper.toDTO(visitor);
    }

    @PostMapping
    public VisitorDTO criar(@RequestBody VisitorDTO dto) {
        Company company = null;
        if (dto.getCompanyId() != null) {
            company = companyRepository.findById(dto.getCompanyId())
                    .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
        }
        Visitor visitor = VisitorMapper.toEntity(dto, company);
        Visitor saved = visitorRepository.save(visitor);
        return VisitorMapper.toDTO(saved);
    }

    @PutMapping("/{id}")
    public VisitorDTO atualizar(@PathVariable Long id, @RequestBody VisitorDTO dto) {
        Visitor existente = visitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Visitor não encontrado"));
        Company company = null;
        if (dto.getCompanyId() != null) {
            company = companyRepository.findById(dto.getCompanyId())
                    .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
        }
        existente.setName(dto.getName());
        existente.setCpf(dto.getCpf());
        try {
            existente.setBirthDate(dto.getBirthDate() != null ? new java.text.SimpleDateFormat("yyyy-MM-dd").parse(dto.getBirthDate()) : null);
        } catch (Exception e) {
            existente.setBirthDate(null);
        }
        existente.setVisitorType(dto.getVisitorType() != null ? com.grupo5.MSVisitor.model.VisitorType.valueOf(dto.getVisitorType()) : null);
        existente.setCompany(company);
        Visitor saved = visitorRepository.save(existente);
        return VisitorMapper.toDTO(saved);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        visitorRepository.deleteById(id);
    }
}