package com.grupo5.MSAccessControl.dto;

import java.time.format.DateTimeFormatter;

import com.grupo5.MSAccessControl.model.Authorization;
import com.grupo5.MSAccessControl.model.AuthorizationStatus;

public class AuthorizationMapper {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Métodos para buscar Resident via REST devem ser implementados no service
    public static AuthorizationDTO toDTO(Authorization authorization, String residentName, String residentType) {
        AuthorizationDTO dto = new AuthorizationDTO();
        dto.setId(authorization.getId());
        dto.setResidentId(authorization.getResidentId());
        dto.setResidentName(residentName);
        dto.setResidentType(residentType);
        dto.setAuthorizationDateTime(authorization.getAuthorizationDateTime() != null ? dtf.format(authorization.getAuthorizationDateTime()) : null);
        dto.setStatus(authorization.getStatus() != null ? authorization.getStatus().name() : null);
        return dto;
    }

    public static Authorization toEntity(AuthorizationDTO dto) {
        Authorization authorization = new Authorization();
        authorization.setId(dto.getId());
        authorization.setResidentId(dto.getResidentId());
        try {
            authorization.setAuthorizationDateTime(dto.getAuthorizationDateTime() != null ? java.time.LocalDateTime.parse(dto.getAuthorizationDateTime(), dtf) : null);
        } catch (Exception e) {
            authorization.setAuthorizationDateTime(null);
        }
        authorization.setStatus(dto.getStatus() != null ? AuthorizationStatus.valueOf(dto.getStatus()) : null);
        return authorization;
    }
} 