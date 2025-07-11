package com.grupo5.MSResident.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Resident extends Person {
    @Enumerated(EnumType.STRING)
    private ResidentType residentType;

    // Getters e setters
    public ResidentType getResidentType() { return residentType; }
    public void setResidentType(ResidentType residentType) { this.residentType = residentType; }
}
