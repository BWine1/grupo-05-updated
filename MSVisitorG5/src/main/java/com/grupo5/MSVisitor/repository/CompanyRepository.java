package com.grupo5.MSVisitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo5.MSVisitor.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
} 