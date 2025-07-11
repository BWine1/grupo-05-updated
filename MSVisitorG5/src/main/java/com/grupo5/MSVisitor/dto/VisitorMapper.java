package com.grupo5.MSVisitor.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.grupo5.MSVisitor.model.Company;
import com.grupo5.MSVisitor.model.Visitor;
import com.grupo5.MSVisitor.model.VisitorType;

public class VisitorMapper {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static VisitorDTO toDTO(Visitor visitor) {
        VisitorDTO dto = new VisitorDTO();
        dto.setId(visitor.getId());
        dto.setName(visitor.getName());
        dto.setCpf(visitor.getCpf());
        Date birthDate = visitor.getBirthDate();
        dto.setBirthDate(birthDate != null ? sdf.format(birthDate) : null);
        dto.setVisitorType(visitor.getVisitorType() != null ? visitor.getVisitorType().name() : null);
        if (visitor.getCompany() != null) {
            dto.setCompanyId(visitor.getCompany().getId());
            dto.setCompanyName(visitor.getCompany().getName());
            dto.setCompanyCnpj(visitor.getCompany().getCnpj());
        }
        return dto;
    }

    public static Visitor toEntity(VisitorDTO dto, Company company) {
        Visitor visitor = new Visitor();
        visitor.setId(dto.getId());
        visitor.setName(dto.getName());
        visitor.setCpf(dto.getCpf());
        try {
            visitor.setBirthDate(dto.getBirthDate() != null ? sdf.parse(dto.getBirthDate()) : null);
        } catch (Exception e) {
            visitor.setBirthDate(null);
        }
        visitor.setVisitorType(dto.getVisitorType() != null ? VisitorType.valueOf(dto.getVisitorType()) : null);
        visitor.setCompany(company);
        return visitor;
    }
} 