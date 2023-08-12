package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepo extends JpaRepository <Candidate,Integer>{

    Candidate findByEmail(String email);
    boolean existsById(int id);
    boolean existsBySystemUserId(int id);
    Candidate findBySystemUserId(int id);
    Candidate findById(int id);
}
