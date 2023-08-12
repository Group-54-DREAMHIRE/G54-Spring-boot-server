package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Integer> {

    boolean existsById(int id);
    Company findByEmail(String email);
    Company findById(int id);
    boolean existsBySystemUserId(int id);
    Company findBySystemUserId(int id);
}
