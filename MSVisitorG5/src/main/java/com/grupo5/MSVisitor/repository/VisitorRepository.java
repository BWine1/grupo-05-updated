package com.grupo5.MSVisitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo5.MSVisitor.model.Visitor;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
} 