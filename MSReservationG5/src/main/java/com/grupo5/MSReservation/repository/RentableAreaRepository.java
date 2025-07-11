package com.grupo5.MSReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo5.MSReservation.model.RentableArea;

public interface RentableAreaRepository extends JpaRepository<RentableArea, Long> {
} 