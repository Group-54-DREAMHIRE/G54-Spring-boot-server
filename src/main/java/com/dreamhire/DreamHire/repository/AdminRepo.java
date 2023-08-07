package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

    Admin findByEmail(String email);
}
