package com.grupo5.MSResident.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.grupo5.MSResident.model.Resident;
import com.grupo5.MSResident.model.ResidentType;

public class ResidentMapper {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static ResidentDTO toDTO(Resident resident) {
        ResidentDTO dto = new ResidentDTO();
        dto.setId(resident.getId());
        dto.setName(resident.getName());
        dto.setCpf(resident.getCpf());
        Date birthDate = resident.getBirthDate();
        dto.setBirthDate(birthDate != null ? sdf.format(birthDate) : null);
        dto.setResidentType(resident.getResidentType() != null ? resident.getResidentType().name() : null);
        return dto;
    }

    public static Resident toEntity(ResidentDTO dto) {
        Resident resident = new Resident();
        resident.setId(dto.getId());
        resident.setName(dto.getName());
        resident.setCpf(dto.getCpf());
        try {
            resident.setBirthDate(dto.getBirthDate() != null ? sdf.parse(dto.getBirthDate()) : null);
        } catch (Exception e) {
            resident.setBirthDate(null);
        }
        resident.setResidentType(dto.getResidentType() != null ? ResidentType.valueOf(dto.getResidentType()) : null);
        return resident;
    }
} 