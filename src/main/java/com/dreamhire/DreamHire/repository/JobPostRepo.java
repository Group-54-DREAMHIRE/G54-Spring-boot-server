package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.dto.JobPostDTO;
import com.dreamhire.DreamHire.dto.PostedJobsDTO;
import com.dreamhire.DreamHire.dto.SendCandidateResumeDTO;
import com.dreamhire.DreamHire.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobPostRepo extends JpaRepository<JobPost, Integer> {

    boolean existsById(int id);
    JobPost findById(int id);
    boolean existsById(Integer integer);


    @Query(value = "SELECT * FROM jobpost WHERE validate=true  ", nativeQuery = true)
    List<JobPost> getAllValidateJobPosts();

    @Modifying
    @Query(value = "SELECT * FROM jobpost WHERE company_id = id;", nativeQuery = true)
    List<JobPost> getJobPostsByCompanyId(int id);

    @Query(value = "select JP.id, JP.job_title,JP.tags,JP.validate,JP.deadline,JP.number_of_vacancies, COUNT(AJC.id)   FROM apply_job_candidate AJC LEFT JOIN jobpost JP ON JP.id = AJC.job_id WHERE JP.company_id = :id GROUP BY  JP.id;",nativeQuery = true)
    List<Object[]> getJobs(int id);

    @Query(value = "SELECT * FROM JobPost WHERE (:jobTitle is null  or job_title=:jobTitle)" +
            " AND (:jobType is null  or job_type=:jobType)" +
            " AND (:salary is null  or min_salary=:salary) " +
            " AND (:experience is null  or experience=:experience) ", nativeQuery = true)
    List<JobPost> getSearchJobs(@Param(value = "jobTitle") String jobTitle,
                                @Param(value = "jobType") String jobType,
                                @Param(value = "salary") String salary,
                                @Param(value = "experience") String experience
                                );

}
