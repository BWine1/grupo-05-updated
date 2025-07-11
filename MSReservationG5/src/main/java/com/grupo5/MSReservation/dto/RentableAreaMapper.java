package com.grupo5.MSReservation.dto;

import com.grupo5.MSReservation.model.RentableArea;

public class RentableAreaMapper {
    public static RentableAreaDTO toDTO(RentableArea area) {
        RentableAreaDTO dto = new RentableAreaDTO();
        dto.setId(area.getId());
        dto.setName(area.getName());
        dto.setSize(area.getSize());
        dto.setCapacity(area.getCapacity());
        return dto;
    }

    public static RentableArea toEntity(RentableAreaDTO dto) {
        RentableArea area = new RentableArea();
        area.setId(dto.getId());
        area.setName(dto.getName());
        area.setSize(dto.getSize());
        area.setCapacity(dto.getCapacity());
        return area;
    }
} 