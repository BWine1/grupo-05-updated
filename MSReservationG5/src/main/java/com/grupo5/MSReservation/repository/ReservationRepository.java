package com.grupo5.MSReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo5.MSReservation.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
} 