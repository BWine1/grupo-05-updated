package com.grupo5.MSVisitor.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cnpj;

    @OneToMany(mappedBy = "company")
    private List<Visitor> visitors;

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public List<Visitor> getVisitors() { return visitors; }
    public void setVisitors(List<Visitor> visitors) { this.visitors = visitors; }
} 