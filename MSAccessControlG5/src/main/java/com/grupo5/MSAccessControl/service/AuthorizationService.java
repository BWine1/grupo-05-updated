package com.grupo5.MSAccessControl.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.grupo5.MSAccessControl.dto.AuthorizationDTO;
import com.grupo5.MSAccessControl.dto.AuthorizationMapper;
import com.grupo5.MSAccessControl.model.Authorization;
import com.grupo5.MSAccessControl.model.AuthorizationStatus;
import com.grupo5.MSAccessControl.repository.AuthorizationRepository;

@Service
public class AuthorizationService {
    private final AuthorizationRepository authorizationRepository;
    private final ExternalPersonService externalPersonService;

    public AuthorizationService(AuthorizationRepository authorizationRepository, ExternalPersonService externalPersonService) {
        this.authorizationRepository = authorizationRepository;
        this.externalPersonService = externalPersonService;
    }

    public AuthorizationDTO save(AuthorizationDTO dto) {
        Authorization authorization = AuthorizationMapper.toEntity(dto);
        authorization.setStatus(AuthorizationStatus.PENDING); // default status
        Authorization saved = authorizationRepository.save(authorization);
        return toDTOWithExternal(saved);
    }

    public Optional<AuthorizationDTO> findById(Long id) {
        return authorizationRepository.findById(id).map(this::toDTOWithExternal);
    }

    public List<AuthorizationDTO> findAll() {
        return authorizationRepository.findAll().stream().map(this::toDTOWithExternal).collect(Collectors.toList());
    }

    public AuthorizationDTO update(Long id, AuthorizationDTO dto) {
        Authorization existing = authorizationRepository.findById(id).orElseThrow(() -> new RuntimeException("Authorization não encontrada"));
        existing.setAuthorizationDateTime(dto.getAuthorizationDateTime() != null ? AuthorizationMapper.toEntity(dto).getAuthorizationDateTime() : existing.getAuthorizationDateTime());
        existing.setStatus(dto.getStatus() != null ? AuthorizationStatus.valueOf(dto.getStatus()) : existing.getStatus());
        Authorization saved = authorizationRepository.save(existing);
        return toDTOWithExternal(saved);
    }

    public void delete(Long id) {
        authorizationRepository.deleteById(id);
    }

    private AuthorizationDTO toDTOWithExternal(Authorization authorization) {
        var resident = externalPersonService.getResidentById(authorization.getResidentId());
        return AuthorizationMapper.toDTO(
            authorization,
            resident != null ? resident.getName() : null,
            resident != null ? resident.getResidentType() : null
        );
    }
} 