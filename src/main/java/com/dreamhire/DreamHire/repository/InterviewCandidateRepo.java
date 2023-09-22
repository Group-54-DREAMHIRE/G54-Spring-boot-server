package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.InterviewCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InterviewCandidateRepo extends JpaRepository<InterviewCandidate, Integer> {
    InterviewCandidate findById(int id);

    @Query(value = "SELECT * FROM interview_candidate WHERE can_id = :id AND status= 'accept';",nativeQuery = true)
    List<InterviewCandidate> getAllInterviewsByCandidateId(int id);

    @Query(value = "SELECT * FROM interview_candidate INTC  JOIN interviews INTV ON INTC.int_id = INTV.id  WHERE INTC.can_id = :id AND INTV.job_id = :jobId;",nativeQuery = true)
    List<Object[]> getScheduledInterviewsByJobAndCandidateId(int id, int jobId);

}
