package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateRepo extends JpaRepository <Candidate,Integer>{

    Optional<Candidate> findByEmail(String email);
}
