package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.CompanyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyUserRepo extends JpaRepository<CompanyUser, Integer> {

    List<CompanyUser> findAllByCompanyId(int id);
}
