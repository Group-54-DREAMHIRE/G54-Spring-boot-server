package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.Company;
import com.dreamhire.DreamHire.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepo extends JpaRepository<Company, Integer> {

    boolean existsById(int id);
    Company findByEmail(String email);
    Company findById(int id);
    boolean existsBySystemUserId(int id);
    Company findBySystemUserId(int id);

    @Query(value = "SELECT * FROM companies WHERE approval=true AND visible= true", nativeQuery = true)
    List<Company> getAllApprovedVisibleCompanies();
}
