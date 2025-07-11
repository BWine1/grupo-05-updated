package com.grupo5.MSAccessControl.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Authorization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long residentId;
    private LocalDateTime authorizationDateTime;
    @Enumerated(EnumType.STRING)
    private AuthorizationStatus status;

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getResidentId() { return residentId; }
    public void setResidentId(Long residentId) { this.residentId = residentId; }
    public LocalDateTime getAuthorizationDateTime() { return authorizationDateTime; }
    public void setAuthorizationDateTime(LocalDateTime authorizationDateTime) { this.authorizationDateTime = authorizationDateTime; }
    public AuthorizationStatus getStatus() { return status; }
    public void setStatus(AuthorizationStatus status) { this.status = status; }
} 