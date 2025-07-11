package com.grupo5.MSVisitor.dto;

public class VisitorDTO {
    private Long id;
    private String name;
    private String cpf;
    private String birthDate;
    private String visitorType;
    private Long companyId;
    private String companyName;
    private String companyCnpj;

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
    public String getVisitorType() { return visitorType; }
    public void setVisitorType(String visitorType) { this.visitorType = visitorType; }
    public Long getCompanyId() { return companyId; }
    public void setCompanyId(Long companyId) { this.companyId = companyId; }
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public String getCompanyCnpj() { return companyCnpj; }
    public void setCompanyCnpj(String companyCnpj) { this.companyCnpj = companyCnpj; }
} 