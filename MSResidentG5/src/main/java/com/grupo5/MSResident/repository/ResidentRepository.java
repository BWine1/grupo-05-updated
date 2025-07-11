package com.grupo5.MSResident.repository;

import com.grupo5.MSResident.model.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends JpaRepository<Resident, Long> {
}
