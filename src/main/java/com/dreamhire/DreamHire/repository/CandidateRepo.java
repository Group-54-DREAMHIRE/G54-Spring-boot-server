package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateRepo extends JpaRepository <Candidate,Integer>{

    Candidate findByEmail(String email);
    boolean existsById(int id);
    boolean existsBySystemUserId(int id);
    Candidate findBySystemUserId(int id);
    Candidate findById(int id);

    @Query(value = "SELECT * FROM candidates WHERE visible= true", nativeQuery = true)
    List<Candidate> getAllVisibleCandidates();
}
