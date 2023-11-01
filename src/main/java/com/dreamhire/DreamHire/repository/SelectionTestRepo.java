package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.InterviewCandidate;
import com.dreamhire.DreamHire.model.SelectionTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SelectionTestRepo extends JpaRepository<SelectionTest,Integer> {

    List<SelectionTest> findByCompanyId(int id);

    SelectionTest findById(int id);

    @Query(value = "SELECT * FROM selection_test WHERE can_id = :id AND job_id = :jobId",nativeQuery = true)
    List<SelectionTest> getAllTestsByCandidateAndJobId(int id, int jobId);

    List<SelectionTest> findAllByJobPostId(int id);
}
