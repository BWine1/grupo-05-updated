package com.grupo5.MSAccessControl.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.grupo5.MSAccessControl.dto.VisitDTO;
import com.grupo5.MSAccessControl.dto.VisitMapper;
import com.grupo5.MSAccessControl.model.Visit;
import com.grupo5.MSAccessControl.model.VisitorStatus;
import com.grupo5.MSAccessControl.repository.VisitRepository;

@Service
public class VisitService {
    private final VisitRepository visitRepository;
    private final ExternalPersonService externalPersonService;
    private final RabbitTemplate rabbitTemplate;
    private final String rabbitQueue;

    public VisitService(VisitRepository visitRepository, ExternalPersonService externalPersonService, RabbitTemplate rabbitTemplate, @Value("${rabbitmq.visit.queue:visit-events}") String rabbitQueue) {
        this.visitRepository = visitRepository;
        this.externalPersonService = externalPersonService;
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitQueue = rabbitQueue;
    }

    public VisitDTO save(VisitDTO dto) {
        Visit visit = VisitMapper.toEntity(dto);
        visit.setStatus(VisitorStatus.WAITING); // default status
        Visit saved = visitRepository.save(visit);
        publishVisitEvent(saved);
        return toDTOWithExternal(saved);
    }

    public Optional<VisitDTO> findById(Long id) {
        return visitRepository.findById(id).map(this::toDTOWithExternal);
    }

    public List<VisitDTO> findAll() {
        return visitRepository.findAll().stream().map(this::toDTOWithExternal).collect(Collectors.toList());
    }

    public VisitDTO update(Long id, VisitDTO dto) {
        Visit existing = visitRepository.findById(id).orElseThrow(() -> new RuntimeException("Visit não encontrada"));
        existing.setEntry(dto.getEntry() != null ? VisitMapper.toEntity(dto).getEntry() : existing.getEntry());
        existing.setExit(dto.getExit() != null ? VisitMapper.toEntity(dto).getExit() : existing.getExit());
        existing.setStatus(dto.getStatus() != null ? VisitorStatus.valueOf(dto.getStatus()) : existing.getStatus());
        Visit saved = visitRepository.save(existing);
        publishVisitEvent(saved);
        return toDTOWithExternal(saved);
    }

    public void delete(Long id) {
        visitRepository.deleteById(id);
    }

    private VisitDTO toDTOWithExternal(Visit visit) {
        var visitor = externalPersonService.getVisitorById(visit.getVisitorId());
        var resident = externalPersonService.getResidentById(visit.getResidentId());
        return VisitMapper.toDTO(
            visit,
            visitor != null ? visitor.getName() : null,
            visitor != null ? visitor.getVisitorType() : null,
            resident != null ? resident.getName() : null,
            resident != null ? resident.getResidentType() : null
        );
    }

    private void publishVisitEvent(Visit visit) {
        // Pode customizar o payload conforme necessário
        rabbitTemplate.convertAndSend(rabbitQueue, visit.getId());
    }
} 