package com.grupo5.MSResident.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo5.MSResident.dto.ResidentDTO;
import com.grupo5.MSResident.dto.ResidentMapper;
import com.grupo5.MSResident.model.Resident;
import com.grupo5.MSResident.service.ResidentService;

@RestController
@RequestMapping("/resident")
public class ResidentController {
    private final ResidentService service;

    public ResidentController(ResidentService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResidentDTO getResident(@PathVariable Long id) {
        Resident resident = service.findById(id).orElseThrow(() -> new RuntimeException("Resident não encontrado"));
        return ResidentMapper.toDTO(resident);
    }

    @PostMapping
    public ResidentDTO createResident(@RequestBody ResidentDTO dto) {
        Resident resident = ResidentMapper.toEntity(dto);
        Resident saved = service.save(resident);
        return ResidentMapper.toDTO(saved);
    }

    @GetMapping("/permissions/{id}")
    public Map<String, Object> getPermissions(@PathVariable Long id) {
        // Simulação de permissões
        return Map.of(
            "residentId", id,
            "horarioPermitido", "08:00-20:00",
            "acessoAreas", new String[]{"Academia", "Piscina", "Salão de Festas"}
        );
    }

    @GetMapping("/test")
    public String test() {
        return "MSResident rodando na porta 8081!";
    }

    @GetMapping
    public List<ResidentDTO> getAllResidents() {
        return service.findAll().stream().map(ResidentMapper::toDTO).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResidentDTO updateResident(@PathVariable Long id, @RequestBody ResidentDTO dto) {
        Resident updated = service.update(id, ResidentMapper.toEntity(dto));
        return ResidentMapper.toDTO(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteResident(@PathVariable Long id) {
        service.delete(id);
    }
}
