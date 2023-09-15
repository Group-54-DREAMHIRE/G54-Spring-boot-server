package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.SavedJobDTO;
import com.dreamhire.DreamHire.model.Candidate;
import com.dreamhire.DreamHire.model.JobPost;
import com.dreamhire.DreamHire.model.SavedJobs;
import com.dreamhire.DreamHire.repository.CandidateRepo;
import com.dreamhire.DreamHire.repository.JobPostRepo;
import com.dreamhire.DreamHire.repository.SavedJobsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/savedJobs")
public class SavedJobController {

    @Autowired
    private SavedJobsRepo savedJobsRepo;
    @Autowired
    private JobPostRepo jobPostRepo;
    @Autowired
    private CandidateRepo candidateRepo;

    @PostMapping("/save/{id}")
    public ResponseEntity<?> saveJob(@PathVariable int id, @RequestBody SavedJobDTO savedJob) {
        SavedJobs savedJobs = new SavedJobs();
        savedJobs.setJobPost(jobPostRepo.findById(savedJob.getJobId()));
        savedJobs.setCandidate(candidateRepo.findById(id));
        savedJobsRepo.save(savedJobs);
        return new ResponseEntity<>("Successfully saved", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable int id){
        savedJobsRepo.deleteById(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    @GetMapping("/getAll/{id}")
    public ResponseEntity<?> getSavedJobs(@PathVariable int id){
        List<SavedJobs> savedJobs = savedJobsRepo.getSavedJobsByCandidateId(id);
        return new ResponseEntity<>(savedJobs, HttpStatus.OK);
    }
}
