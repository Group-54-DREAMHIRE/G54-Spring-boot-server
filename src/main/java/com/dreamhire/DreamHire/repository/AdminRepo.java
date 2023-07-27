package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

    Optional<Admin> findById(String email);
}
