package com.grupo5.MSAccessControl.dto;

public class VisitDTO {
    private Long id;
    private Long visitorId;
    private String visitorName;
    private String visitorType;
    private Long residentId;
    private String residentName;
    private String residentType;
    private String entry;
    private String exit;
    private String status;

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getVisitorId() { return visitorId; }
    public void setVisitorId(Long visitorId) { this.visitorId = visitorId; }
    public String getVisitorName() { return visitorName; }
    public void setVisitorName(String visitorName) { this.visitorName = visitorName; }
    public String getVisitorType() { return visitorType; }
    public void setVisitorType(String visitorType) { this.visitorType = visitorType; }
    public Long getResidentId() { return residentId; }
    public void setResidentId(Long residentId) { this.residentId = residentId; }
    public String getResidentName() { return residentName; }
    public void setResidentName(String residentName) { this.residentName = residentName; }
    public String getResidentType() { return residentType; }
    public void setResidentType(String residentType) { this.residentType = residentType; }
    public String getEntry() { return entry; }
    public void setEntry(String entry) { this.entry = entry; }
    public String getExit() { return exit; }
    public void setExit(String exit) { this.exit = exit; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
} 