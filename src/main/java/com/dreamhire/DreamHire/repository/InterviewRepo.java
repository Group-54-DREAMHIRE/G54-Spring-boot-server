package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InterviewRepo extends JpaRepository<Interview, Integer> {

    Interview findById(int id);
    @Query(value = "SELECT * FROM interviews WHERE job_id=:jobId AND type='technical' AND free = true;", nativeQuery = true)
    List<Interview> getTechInterviewByJobPostId(int jobId);

    @Query(value = "SELECT * FROM interviews WHERE job_id=:jobId AND type='hr' AND free = true;", nativeQuery = true)
    List<Interview> getHrInterviewByJobPostId(int jobId);

}
