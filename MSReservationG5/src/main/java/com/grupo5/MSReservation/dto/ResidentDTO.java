package com.grupo5.MSReservation.dto;

public class ResidentDTO {
    private Long id;
    private String name;
    private String cpf;
    private String birthDate;
    private String residentType;

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
    public String getResidentType() { return residentType; }
    public void setResidentType(String residentType) { this.residentType = residentType; }
} 