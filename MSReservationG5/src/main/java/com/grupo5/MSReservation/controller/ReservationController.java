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

import com.grupo5.MSReservation.dto.ReservationDTO;
import com.grupo5.MSReservation.dto.ReservationMapper;
import com.grupo5.MSReservation.model.Reservation;
import com.grupo5.MSReservation.repository.RentableAreaRepository;
import com.grupo5.MSReservation.repository.ReservationRepository;
import com.grupo5.MSReservation.service.ExternalResidentService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationRepository reservationRepository;
    private final RentableAreaRepository areaRepository;
    private final ExternalResidentService residentService;

    public ReservationController(ReservationRepository reservationRepository, RentableAreaRepository areaRepository, ExternalResidentService residentService) {
        this.reservationRepository = reservationRepository;
        this.areaRepository = areaRepository;
        this.residentService = residentService;
    }

    @GetMapping
    public List<ReservationDTO> getAll() {
        return reservationRepository.findAll().stream().map(this::toDTOWithExternal).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ReservationDTO getById(@PathVariable Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
        return toDTOWithExternal(reservation);
    }

    @PostMapping
    public ReservationDTO create(@RequestBody ReservationDTO dto) {
        Reservation reservation = ReservationMapper.toEntity(dto);
        Reservation saved = reservationRepository.save(reservation);
        return toDTOWithExternal(saved);
    }

    @PutMapping("/{id}")
    public ReservationDTO update(@PathVariable Long id, @RequestBody ReservationDTO dto) {
        Reservation existing = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
        Reservation updated = ReservationMapper.toEntity(dto);
        updated.setId(id);
        Reservation saved = reservationRepository.save(updated);
        return toDTOWithExternal(saved);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reservationRepository.deleteById(id);
    }

    private ReservationDTO toDTOWithExternal(Reservation reservation) {
        String areaName = areaRepository.findById(reservation.getIdArea()).map(a -> a.getName()).orElse(null);
        String residentName = null;
        var resident = residentService.getResidentById(reservation.getIdResident());
        if (resident != null) residentName = resident.getName();
        return ReservationMapper.toDTO(reservation, areaName, residentName);
    }
} 