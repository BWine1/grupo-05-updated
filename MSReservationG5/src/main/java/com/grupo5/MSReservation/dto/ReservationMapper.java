package com.grupo5.MSReservation.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.grupo5.MSReservation.model.Reservation;
import com.grupo5.MSReservation.model.ReservationStatus;

public class ReservationMapper {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static ReservationDTO toDTO(Reservation reservation, String areaName, String residentName) {
        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setIdArea(reservation.getIdArea());
        dto.setAreaName(areaName);
        dto.setIdResident(reservation.getIdResident());
        dto.setResidentName(residentName);
        dto.setActive(reservation.isActive());
        Date start = reservation.getStartDate();
        dto.setStartDate(start != null ? sdf.format(start) : null);
        Date end = reservation.getEndDate();
        dto.setEndDate(end != null ? sdf.format(end) : null);
        dto.setDescription(reservation.getDescription());
        dto.setStatus(reservation.getStatus() != null ? reservation.getStatus().name() : null);
        if (reservation.getNotification() != null) {
            dto.setNotificationType(reservation.getNotification().getClass().getSimpleName());
            if (reservation.getNotification() instanceof com.grupo5.MSReservation.model.Email email) {
                dto.setNotificationTarget(email.getProviderName());
            } else if (reservation.getNotification() instanceof com.grupo5.MSReservation.model.SMS sms) {
                dto.setNotificationTarget(sms.getOperatorName());
            }
        }
        return dto;
    }

    public static Reservation toEntity(ReservationDTO dto) {
        Reservation reservation = new Reservation();
        reservation.setId(dto.getId());
        reservation.setIdArea(dto.getIdArea());
        reservation.setIdResident(dto.getIdResident());
        reservation.setActive(dto.isActive());
        try {
            reservation.setStartDate(dto.getStartDate() != null ? sdf.parse(dto.getStartDate()) : null);
        } catch (Exception e) {
            reservation.setStartDate(null);
        }
        try {
            reservation.setEndDate(dto.getEndDate() != null ? sdf.parse(dto.getEndDate()) : null);
        } catch (Exception e) {
            reservation.setEndDate(null);
        }
        reservation.setDescription(dto.getDescription());
        reservation.setStatus(dto.getStatus() != null ? ReservationStatus.valueOf(dto.getStatus()) : null);
        if (dto.getNotificationType() != null) {
            if (dto.getNotificationType().equalsIgnoreCase("Email")) {
                reservation.setNotification(new com.grupo5.MSReservation.model.Email(dto.getNotificationTarget()));
            } else if (dto.getNotificationType().equalsIgnoreCase("SMS")) {
                reservation.setNotification(new com.grupo5.MSReservation.model.SMS(dto.getNotificationTarget()));
            }
        }
        return reservation;
    }
} 