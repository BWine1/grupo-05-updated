package com.grupo5.MSVisitor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Visitor extends Person {
    @Enumerated(EnumType.STRING)
    private VisitorType visitorType;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    // Getters e setters
    public VisitorType getVisitorType() { return visitorType; }
    public void setVisitorType(VisitorType visitorType) { this.visitorType = visitorType; }
    public Company getCompany() { return company; }
    public void setCompany(Company company) { this.company = company; }
} 