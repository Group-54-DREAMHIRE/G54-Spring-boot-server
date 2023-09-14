package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.SavedJobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SavedJobsRepo extends JpaRepository<SavedJobs, Integer> {
    List<SavedJobs> getSavedJobsByCandidateId(int id);

    @Query(value = "DELETE FROM saved_jobs WHERE can_id = :id AND job_id=:jobId;", nativeQuery = true)
    void deleteSavedJob(int id, int jobId);
}
