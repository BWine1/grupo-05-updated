package com.grupo5.MSAccessControl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo5.MSAccessControl.model.Authorization;

public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {
} 