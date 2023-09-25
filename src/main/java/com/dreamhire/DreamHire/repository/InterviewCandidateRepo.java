package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.InterviewCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InterviewCandidateRepo extends JpaRepository<InterviewCandidate, Integer> {
    InterviewCandidate findById(int id);

    @Query(value = "SELECT * FROM interview_candidate WHERE can_id = :id AND status= 'accepted';",nativeQuery = true)
    List<InterviewCandidate> getAllInterviewsByCandidateId(int id);

    @Query(value = "SELECT INTV.id,INTC.report,INTV.start_time,INTV.duration,INTV.with_int,INTV.type,JP.company_name FROM interview_candidate INTC  JOIN interviews INTV ON INTC.int_id = INTV.id JOIN jobpost JP ON INTV.job_id = JP.id  WHERE INTC.can_id = :id AND INTV.job_id = :jobId AND INTC.status='accepted'; ",nativeQuery = true)
    List<Object[]> getScheduledInterviewsById(int id, int jobId);

}
