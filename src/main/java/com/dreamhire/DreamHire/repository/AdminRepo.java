package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
    boolean existsById(int id);
    Admin findById(int id);
    boolean existsBySystemUserId(int id);
    Admin findBySystemUserId(int id);

}
