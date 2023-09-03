package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.dto.JobPostDTO;
import com.dreamhire.DreamHire.dto.PostedJobsDTO;
import com.dreamhire.DreamHire.dto.SendCandidateResumeDTO;
import com.dreamhire.DreamHire.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobPostRepo extends JpaRepository<JobPost, Integer> {

    JobPost findById(int id);

    @Query(value = "SELECT * FROM jobpost WHERE validate=true  ", nativeQuery = true)
    List<JobPost> getAllValidateJobPosts();

    @Query(value = "SELECT job.job_title ,job.tags ,job.validate,job.deadline,job.id,job.number_of_vacancies, COUNT(ajc.id)  FROM jobpost job LEFT JOIN apply_job_candidate ajc ON ajc.job_id = job.id WHERE job.company_id = 1 GROUP BY job.job_title,job.tags,job.validate,job.deadline,job.id,job.number_of_vacancies;", nativeQuery = true)
    List<PostedJobsDTO> getJobPostsByCompanyId(int id);
}
