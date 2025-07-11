package com.grupo5.MSAccessControl.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.grupo5.MSAccessControl.model.Visit;
import com.grupo5.MSAccessControl.model.VisitorStatus;

public class VisitMapper {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // Métodos para buscar Visitor/Resident via REST devem ser implementados no service
    public static VisitDTO toDTO(Visit visit, String visitorName, String visitorType, String residentName, String residentType) {
        VisitDTO dto = new VisitDTO();
        dto.setId(visit.getId());
        dto.setVisitorId(visit.getVisitorId());
        dto.setVisitorName(visitorName);
        dto.setVisitorType(visitorType);
        dto.setResidentId(visit.getResidentId());
        dto.setResidentName(residentName);
        dto.setResidentType(residentType);
        Date entry = visit.getEntry();
        dto.setEntry(entry != null ? sdf.format(entry) : null);
        Date exit = visit.getExit();
        dto.setExit(exit != null ? sdf.format(exit) : null);
        dto.setStatus(visit.getStatus() != null ? visit.getStatus().name() : null);
        return dto;
    }

    public static Visit toEntity(VisitDTO dto) {
        Visit visit = new Visit();
        visit.setId(dto.getId());
        visit.setVisitorId(dto.getVisitorId());
        visit.setResidentId(dto.getResidentId());
        try {
            visit.setEntry(dto.getEntry() != null ? sdf.parse(dto.getEntry()) : null);
        } catch (Exception e) {
            visit.setEntry(null);
        }
        try {
            visit.setExit(dto.getExit() != null ? sdf.parse(dto.getExit()) : null);
        } catch (Exception e) {
            visit.setExit(null);
        }
        visit.setStatus(dto.getStatus() != null ? VisitorStatus.valueOf(dto.getStatus()) : null);
        return visit;
    }
} 