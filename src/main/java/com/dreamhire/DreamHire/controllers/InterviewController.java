package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.GetInterviewDTO;
import com.dreamhire.DreamHire.dto.InterviewDTO;
import com.dreamhire.DreamHire.model.ApplyJobCandidate;
import com.dreamhire.DreamHire.model.Interview;
import com.dreamhire.DreamHire.repository.ApplyJobCandidateRepo;
import com.dreamhire.DreamHire.repository.CandidateRepo;
import com.dreamhire.DreamHire.repository.InterviewRepo;
import com.dreamhire.DreamHire.repository.JobPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("api/v1/interview")
public class InterviewController {
    @Autowired
    private InterviewRepo interviewRepo;

    @Autowired
    private JobPostRepo jobPostRepo;

    @Autowired
    private ApplyJobCandidateRepo applyJobCandidateRepo;

    @PostMapping("/save")
    public ResponseEntity<?> saveInterview(@RequestBody List<InterviewDTO> interviews){
        for(int i = 0; i <interviews.size(); i++){
            System.out.println(1);
            System.out.println(interviews.get(i).getStartTime());
            Interview interview = new Interview(interviews.get(i));
            interview.setJobPost(jobPostRepo.findById(interviews.get(i).getJobId()));
            interviewRepo.save(interview);
        }
        return new ResponseEntity<>("Saved Successfully", HttpStatus.OK);
    }

    @PostMapping("/getScheduledTechInterviews/{id}")
    public ResponseEntity<?> getScheduledTechInterviews(@PathVariable int id, @RequestBody GetInterviewDTO getInterview){
        if(Objects.equals(applyJobCandidateRepo.findByCandidateId(id).getCandidateType().toString(), "shortlist")){
            if(jobPostRepo.existsById(getInterview.getJobId())){
                List<Interview >interview = interviewRepo.getTechInterviewByJobPostId(getInterview.getJobId());
                return new ResponseEntity<>(interview,HttpStatus.OK);
            }else{
                return new ResponseEntity<>("There is no job post by this id!",HttpStatus.BAD_REQUEST);
            }
        }else {
            return new ResponseEntity<>("No Data",HttpStatus.OK);
        }


    }

    @PostMapping("/getScheduledHrInterviews/{id}")
    public ResponseEntity<?> getScheduledHrTechInterviews(@PathVariable int id, @RequestBody GetInterviewDTO getInterview){
        if(Objects.equals(applyJobCandidateRepo.findByCandidateId(id).getCandidateType().toString(), "shortlist")){
            if(jobPostRepo.existsById(getInterview.getJobId())){
                List<Interview >interview = interviewRepo.getTechInterviewByJobPostId(getInterview.getJobId());
                return new ResponseEntity<>(interview,HttpStatus.OK);
            }else{
                return new ResponseEntity<>("There is no job post by this id!",HttpStatus.BAD_REQUEST);
            }
        }else {
            return new ResponseEntity<>("No Data",HttpStatus.OK);
        }


    }

}
