package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.dto.JobPostDTO;
import com.dreamhire.DreamHire.dto.PostedJobsDTO;
import com.dreamhire.DreamHire.dto.SendCandidateResumeDTO;
import com.dreamhire.DreamHire.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobPostRepo extends JpaRepository<JobPost, Integer> {

    JobPost findById(int id);

    @Query(value = "SELECT * FROM jobpost WHERE validate=true  ", nativeQuery = true)
    List<JobPost> getAllValidateJobPosts();

    @Modifying
    @Query(value = "SELECT * FROM jobpost WHERE company_id = id;", nativeQuery = true)
    List<JobPost> getJobPostsByCompanyId(int id);
}
