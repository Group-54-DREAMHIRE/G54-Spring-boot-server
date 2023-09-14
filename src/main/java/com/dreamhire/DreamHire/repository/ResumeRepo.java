package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepo extends JpaRepository<Resume, Integer> {
    boolean existsByCandidateId(int id);
    Resume findByCandidateId(int id);
    Resume findById(int id);
}
