package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.ApplyJobDTO;
import com.dreamhire.DreamHire.dto.CanselJobDTO;
import com.dreamhire.DreamHire.dto.SendCandidateResumeDTO;
import com.dreamhire.DreamHire.model.ApplyJobCandidate;
import com.dreamhire.DreamHire.model.CandidateType;
import com.dreamhire.DreamHire.repository.ApplyJobCandidateRepo;
import com.dreamhire.DreamHire.repository.CandidateRepo;
import com.dreamhire.DreamHire.repository.JobPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/applyjobcandidate")
public class ApplyJobCandidateController {

    @Autowired
    private JobPostRepo jobPostRepo;
    @Autowired
    private CandidateRepo candidateRepo;
    @Autowired
    private ApplyJobCandidateRepo applyJobCandidateRepo;

    @PostMapping(path = "/save/{id}")
    public ResponseEntity<?> saveApplyJobCandidate(@PathVariable int id, @RequestBody ApplyJobDTO applyJob){
        if(applyJobCandidateRepo.existsByCandidateId(id)){
            return new ResponseEntity<>("already applied", HttpStatus.BAD_REQUEST);
        }
        ApplyJobCandidate applyJobCandidate = new ApplyJobCandidate(applyJob);
        applyJobCandidate.setJobPost(jobPostRepo.findById(applyJob.getJobID()));
        applyJobCandidate.setCandidate(candidateRepo.findById(id));
        applyJobCandidateRepo.save(applyJobCandidate);
        return new ResponseEntity<>("Apply is successfully", HttpStatus.OK);
    }

    @GetMapping(path = "/getPendingCandidates/{id}")
    public ResponseEntity<?> getPendingCandidates(@PathVariable int id){
        if(jobPostRepo.existsById(id)){
            List <ApplyJobCandidate> applyJobCandidate = applyJobCandidateRepo.getPendingResumes(id);
            return new ResponseEntity<>(applyJobCandidate, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("There is no job post given id", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(path = "/getShortListedCandidates/{id}")
    public ResponseEntity<?> getShortListCandidates(@PathVariable int id){
        if(jobPostRepo.existsById(id)){
            List <ApplyJobCandidate> applyJobCandidate = applyJobCandidateRepo.getShortListResumes(id);
            return new ResponseEntity<>(applyJobCandidate, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("There is no job post given id", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(path = "/getRejectedCandidates/{id}")
    public ResponseEntity<?> getRejectedCandidates(@PathVariable int id){
        if(jobPostRepo.existsById(id)){
            List <ApplyJobCandidate> applyJobCandidate = applyJobCandidateRepo.getRejectedResumes(id);
            return new ResponseEntity<>(applyJobCandidate, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("There is no job post given id", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(path = "/getCanceledCandidates/{id}")
    public ResponseEntity<?> getCanceledCandidates(@PathVariable int id){
        if(jobPostRepo.existsById(id)){
            List <ApplyJobCandidate> applyJobCandidate = applyJobCandidateRepo.getCanceledResumes(id);
            return new ResponseEntity<>(applyJobCandidate, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("There is no job post given id", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(path = "/getAppliedJobs/{id}")
    public ResponseEntity<?> getAppliedJobs(@PathVariable int id){
        if(candidateRepo.existsById(id)){
           List <ApplyJobCandidate> applyJobCandidate = applyJobCandidateRepo.getApplyJobCandidateByCandidateId(id);
           return new ResponseEntity<>(applyJobCandidate,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/cansel/{id}")
    public ResponseEntity<?> canselJob(@PathVariable int id, @RequestBody CanselJobDTO canselJobDTO){
        if(candidateRepo.existsById(id)){
            int jobId = canselJobDTO.getJobId();
            ApplyJobCandidate applyJobCandidate = applyJobCandidateRepo.findByCandidateAndJobPostId(id,jobId);
            applyJobCandidate.setCandidateType(CandidateType.valueOf("cancel"));
            applyJobCandidate.setReason(canselJobDTO.getReason());
            applyJobCandidate.setAppliedDate(canselJobDTO.getCanselDate());
            applyJobCandidateRepo.save(applyJobCandidate);
            return new ResponseEntity<>("Success",HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
