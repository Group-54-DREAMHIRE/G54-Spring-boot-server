package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SystemUserRepository extends JpaRepository<SystemUser, Integer> {
    Optional<SystemUser> findByEmail(String email);
    Boolean existsByEmail(String email);
    Boolean existsByPassword(String password);
}
