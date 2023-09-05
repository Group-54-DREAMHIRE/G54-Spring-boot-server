package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.dto.SendCandidateResumeDTO;
import com.dreamhire.DreamHire.model.ApplyJobCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplyJobCandidateRepo extends JpaRepository<ApplyJobCandidate, Integer> {

    ApplyJobCandidate findById(int id);
    @Query(value = "SELECT AJC.candidate_name, AJC.candidate_city, AJC.currency, AJC.expect_salary, AJC.tags, CAN.title, CAN.id AS canID FROM apply_job_Candidate AJC WHERE candidateType = 'pending' JOIN candidates CAN ON AJC.id = CAN.id JOIN jobpost JOB WHERE JOB.id = id ON JOB.id = AJC.id", nativeQuery = true)
    List<SendCandidateResumeDTO> getPendingResumes(int id);

    @Query(value = "SELECT AJC.candidate_name,AJC.candidate_city, AJC.currency, AJC.expect_salary, AJC.tags, CAN.title, CAN.id  AS canID FROM apply_job_Candidate AJC WHERE candidateType = 'shortlist' JOIN candidates CAN ON AJC.id = CAN.id JOIN jobpost JOB WHERE JOB.id = id ON JOB.id = AJC.id", nativeQuery = true)
    List<SendCandidateResumeDTO> getShortListResumes(int id);

    @Query(value = "SELECT AJC.candidate_name, AJC.candidate_city, AJC.currency, AJC.expect_salary, AJC.tags, CAN.title, CAN.id  AS canID FROM apply_job_Candidate AJC WHERE candidateType = 'reject' JOIN candidates CAN ON AJC.id = CAN.id JOIN jobpost JOB WHERE JOB.id = id ON JOB.id = AJC.id", nativeQuery = true)
    List<SendCandidateResumeDTO> getRejectedResumes(int id);

    @Query(value = "SELECT AJC.candidate_name, AJC.candidate_city, AJC.currency, AJC.expect_salary, AJC.tags, CAN.title, CAN.id  AS canID FROM apply_job_Candidate AJC WHERE candidateType = 'cancel' JOIN candidates CAN ON AJC.id = CAN.id JOIN jobpost JOB WHERE JOB.id = id ON JOB.id = AJC.id", nativeQuery = true)
    List<SendCandidateResumeDTO> getCanceledResumes(int id);

    @Modifying
    @Query(value = "SELECT * FROM apply_job_candidate WHERE can_id = :id ", nativeQuery = true)
    List<ApplyJobCandidate> getApplyJobCandidateByCandidateId(int id);

    boolean existsByCandidateId(int id);
}
