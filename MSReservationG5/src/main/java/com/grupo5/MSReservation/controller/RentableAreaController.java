package com.grupo5.MSReservation.controller;

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

import com.grupo5.MSReservation.dto.RentableAreaDTO;
import com.grupo5.MSReservation.dto.RentableAreaMapper;
import com.grupo5.MSReservation.model.RentableArea;
import com.grupo5.MSReservation.repository.RentableAreaRepository;

@RestController
@RequestMapping("/area")
public class RentableAreaController {
    private final RentableAreaRepository areaRepository;

    public RentableAreaController(RentableAreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @GetMapping
    public List<RentableAreaDTO> getAll() {
        return areaRepository.findAll().stream().map(RentableAreaMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RentableAreaDTO getById(@PathVariable Long id) {
        RentableArea area = areaRepository.findById(id).orElseThrow(() -> new RuntimeException("Área não encontrada"));
        return RentableAreaMapper.toDTO(area);
    }

    @PostMapping
    public RentableAreaDTO create(@RequestBody RentableAreaDTO dto) {
        RentableArea area = RentableAreaMapper.toEntity(dto);
        RentableArea saved = areaRepository.save(area);
        return RentableAreaMapper.toDTO(saved);
    }

    @PutMapping("/{id}")
    public RentableAreaDTO update(@PathVariable Long id, @RequestBody RentableAreaDTO dto) {
        RentableArea existing = areaRepository.findById(id).orElseThrow(() -> new RuntimeException("Área não encontrada"));
        existing.setName(dto.getName());
        existing.setSize(dto.getSize());
        existing.setCapacity(dto.getCapacity());
        RentableArea saved = areaRepository.save(existing);
        return RentableAreaMapper.toDTO(saved);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        areaRepository.deleteById(id);
    }
} 