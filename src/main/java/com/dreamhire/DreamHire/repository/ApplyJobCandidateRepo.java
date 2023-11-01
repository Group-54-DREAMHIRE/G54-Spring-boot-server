package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.dto.SendCandidateResumeDTO;
import com.dreamhire.DreamHire.model.ApplyJobCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplyJobCandidateRepo extends JpaRepository<ApplyJobCandidate, Integer> {

    ApplyJobCandidate findById(int id);
    ApplyJobCandidate findByCandidateId(int id);
    @Modifying
    @Query(value = "SELECT * FROM apply_job_candidate WHERE candidate_type = 'shortlist' AND job_id = :id", nativeQuery = true)
    List<ApplyJobCandidate> getShortListResumes(int id);

    @Modifying
    @Query(value = "SELECT * FROM apply_job_candidate WHERE candidate_type = 'pending' AND job_id = :id", nativeQuery = true)
    List<ApplyJobCandidate> getPendingResumes(int id);

    @Modifying
    @Query(value = "SELECT * FROM apply_job_candidate WHERE candidate_type = 'cansel' AND job_id = :id", nativeQuery = true)
    List<ApplyJobCandidate> getCanceledResumes(int id);

    @Modifying
    @Query(value = "SELECT * FROM apply_job_candidate WHERE candidate_type = 'reject'  AND job_id = :id", nativeQuery = true)
    List<ApplyJobCandidate> getRejectedResumes(int id);


    @Modifying
    @Query(value = "SELECT * FROM apply_job_candidate WHERE can_id = :id AND candidate_type != 'cancel' ", nativeQuery = true)
    List<ApplyJobCandidate> getApplyJobCandidateByCandidateId(int id);

    boolean existsByCandidateId(int id);

    @Query(value = "SELECT * FROM apply_job_candidate WHERE can_id = :id AND job_id = :jobId ",nativeQuery = true)
    ApplyJobCandidate findByCandidateAndJobPostId(int id, int jobId);

}
