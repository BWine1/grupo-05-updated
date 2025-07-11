package com.grupo5.MSResident.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.grupo5.MSResident.model.Resident;
import com.grupo5.MSResident.repository.ResidentRepository;

@Service
public class ResidentService {

    private final ResidentRepository repository;

    public ResidentService(ResidentRepository repository) {
        this.repository = repository;
    }

    public Resident save(Resident resident) {
        return repository.save(resident);
    }

    public Optional<Resident> findById(Long id) {
        return repository.findById(id);
    }

    public List<Resident> findAll() {
        return repository.findAll();
    }

    public Resident update(Long id, Resident resident) {
        Resident existing = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Resident não encontrado"));
        existing.setName(resident.getName());
        existing.setCpf(resident.getCpf());
        existing.setBirthDate(resident.getBirthDate());
        existing.setResidentType(resident.getResidentType());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
