package com.grupo5.MSReservation.dto;

public class ReservationDTO {
    private Long id;
    private Long idArea;
    private String areaName;
    private Long idResident;
    private String residentName;
    private boolean active;
    private String startDate;
    private String endDate;
    private String description;
    private String status;
    private String notificationType;
    private String notificationTarget;

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getIdArea() { return idArea; }
    public void setIdArea(Long idArea) { this.idArea = idArea; }
    public String getAreaName() { return areaName; }
    public void setAreaName(String areaName) { this.areaName = areaName; }
    public Long getIdResident() { return idResident; }
    public void setIdResident(Long idResident) { this.idResident = idResident; }
    public String getResidentName() { return residentName; }
    public void setResidentName(String residentName) { this.residentName = residentName; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getNotificationType() { return notificationType; }
    public void setNotificationType(String notificationType) { this.notificationType = notificationType; }
    public String getNotificationTarget() { return notificationTarget; }
    public void setNotificationTarget(String notificationTarget) { this.notificationTarget = notificationTarget; }
} 