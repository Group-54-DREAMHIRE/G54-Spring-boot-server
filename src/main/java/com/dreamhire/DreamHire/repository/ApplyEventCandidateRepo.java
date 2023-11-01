package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.ApplyEventCandidate;
import com.dreamhire.DreamHire.model.ApplyJobCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplyEventCandidateRepo extends JpaRepository<ApplyEventCandidate, Integer> {
    ApplyEventCandidate findById(int id);

    @Modifying
    @Query(value = "SELECT * FROM apply_event_candidate WHERE can_id = :id", nativeQuery = true)
    List<ApplyEventCandidate> getApplyEventCandidateByCandidateId(int id);
}
