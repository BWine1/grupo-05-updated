package com.grupo5.MSAccessControl.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long visitorId;
    private Long residentId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date entry;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "exit_time")
    private Date exit;

    @Enumerated(EnumType.STRING)
    private VisitorStatus status;

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getVisitorId() { return visitorId; }
    public void setVisitorId(Long visitorId) { this.visitorId = visitorId; }
    public Long getResidentId() { return residentId; }
    public void setResidentId(Long residentId) { this.residentId = residentId; }
    public Date getEntry() { return entry; }
    public void setEntry(Date entry) { this.entry = entry; }
    public Date getExit() { return exit; }
    public void setExit(Date exit) { this.exit = exit; }
    public VisitorStatus getStatus() { return status; }
    public void setStatus(VisitorStatus status) { this.status = status; }
} 