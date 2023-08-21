package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.ApplyJobDTO;
import com.dreamhire.DreamHire.model.ApplyJobCandidate;
import com.dreamhire.DreamHire.repository.ApplyJobCandidateRepo;
import com.dreamhire.DreamHire.repository.CandidateRepo;
import com.dreamhire.DreamHire.repository.JobPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/applyjobcandidate")
public class ApplyJobCandidateController {

    @Autowired
    private JobPostRepo jobPostRepo;
    @Autowired
    private CandidateRepo candidateRepo;
    @Autowired
    private ApplyJobCandidateRepo applyJobCandidateRepo;

    @PostMapping("/save/{id}")
    public ResponseEntity<String> saveApplyJobCandidate(@PathVariable int id, @RequestBody ApplyJobDTO applyJob){
        ApplyJobCandidate applyJobCandidate = new ApplyJobCandidate(applyJob);
        applyJobCandidate.setJobPost(jobPostRepo.findById(applyJob.getJobID()));
        applyJobCandidate.setCandidate(candidateRepo.findById(id));
        applyJobCandidateRepo.save(applyJobCandidate);
        return new ResponseEntity<>("Apply is successfully", HttpStatus.OK);
    }

}
