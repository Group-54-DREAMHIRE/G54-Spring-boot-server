package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepo extends JpaRepository<Company, Integer> {

    Optional<Company> findByEmail(String email);
}
