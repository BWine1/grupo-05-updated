package com.grupo5.MSAccessControl.dto;

public class AuthorizationDTO {
    private Long id;
    private Long residentId;
    private String residentName;
    private String residentType;
    private String authorizationDateTime;
    private String status;

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getResidentId() { return residentId; }
    public void setResidentId(Long residentId) { this.residentId = residentId; }
    public String getResidentName() { return residentName; }
    public void setResidentName(String residentName) { this.residentName = residentName; }
    public String getResidentType() { return residentType; }
    public void setResidentType(String residentType) { this.residentType = residentType; }
    public String getAuthorizationDateTime() { return authorizationDateTime; }
    public void setAuthorizationDateTime(String authorizationDateTime) { this.authorizationDateTime = authorizationDateTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
} 