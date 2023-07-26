package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.LoginItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginItemRepo extends JpaRepository <LoginItems, Integer>{
    Optional<LoginItems> findByUserType(Integer integer);
}
