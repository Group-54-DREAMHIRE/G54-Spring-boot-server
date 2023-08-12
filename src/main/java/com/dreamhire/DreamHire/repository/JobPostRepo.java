package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobPostRepo extends JpaRepository<JobPost, Integer> {

    JobPost findById(int id);

    @Query(value = "SELECT * FROM jobpost WHERE validate=true ", nativeQuery = true)
    List<JobPost> getAllValidateJobPosts();

}
