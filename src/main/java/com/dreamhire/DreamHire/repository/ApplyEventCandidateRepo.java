package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.ApplyEventCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyEventCandidateRepo extends JpaRepository<ApplyEventCandidate, Integer> {
    ApplyEventCandidate findById(int id);
}
