package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.ConfirmIntDTO;
import com.dreamhire.DreamHire.dto.GetInterviewDTO;
import com.dreamhire.DreamHire.dto.PostedJobsDTO;
import com.dreamhire.DreamHire.dto.ScheduledIntDTO;
import com.dreamhire.DreamHire.model.Interview;
import com.dreamhire.DreamHire.model.InterviewCandidate;
import com.dreamhire.DreamHire.repository.CandidateRepo;
import com.dreamhire.DreamHire.repository.InterviewCandidateRepo;
import com.dreamhire.DreamHire.repository.InterviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/interviewCan")
public class InterviewCanController {

    @Autowired
    private InterviewRepo interviewRepo;
    @Autowired
    private InterviewCandidateRepo interviewCandidateRepo;
    @Autowired
    private CandidateRepo candidateRepo;

    @PostMapping("/confirmInterview/{id}")
    public ResponseEntity<?> confirmInterviewTimeSlot(@PathVariable int id, @RequestBody ConfirmIntDTO confirmIntDTO){
        InterviewCandidate interviewCandidate = new InterviewCandidate();
        interviewCandidate.setStatus("accepted");
        interviewCandidate.setCandidate(candidateRepo.findById(id));
        interviewCandidate.setInterview(interviewRepo.findById(confirmIntDTO.getIntId()));
        interviewCandidateRepo.save(interviewCandidate);
        Interview interview = interviewRepo.findById(confirmIntDTO.getIntId());
        interview.setFree(false);
        interviewRepo.save(interview);
        return new ResponseEntity<>("Confirm is success", HttpStatus.OK);
    }

    @GetMapping("/getAllScheduledInterviews/{id}")
    public ResponseEntity<?> getAllScheduledInterviews(@PathVariable int id){
        List<InterviewCandidate> interviewCandidates = interviewCandidateRepo.getAllInterviewsByCandidateId(id);
        return new ResponseEntity<>(interviewCandidates, HttpStatus.OK);
    }

    @PostMapping("/getAppliedJobInterviews/{id}")
    public ResponseEntity<?> getAppliedJobInterviews(@PathVariable int id, @RequestBody GetInterviewDTO getInterviewDTO){
        int jobId = getInterviewDTO.getJobId();
        List<Object[]> interviews = interviewCandidateRepo.getScheduledInterviewsByJobAndCandidateId(id,jobId);
        List<ScheduledIntDTO> scheduledInterviews = new ArrayList<ScheduledIntDTO>();
        System.out.println(scheduledInterviews);
        for (Object[] interview : interviews) {
            ScheduledIntDTO scheduledIntDTO = new ScheduledIntDTO();
            scheduledIntDTO.setId((int) interview[0]);
            scheduledIntDTO.setReport((String) interview[1]);
            scheduledIntDTO.setStartTime((Date) interview[2]);
            scheduledIntDTO.setDuration((Integer) interview[3]);
            scheduledIntDTO.setIntWith((String) interview[4]);
            scheduledIntDTO.setType((String) interview[5]);
            scheduledIntDTO.setCompanyName((String) interview[6]);
            scheduledInterviews.add(scheduledIntDTO);
            scheduledInterviews.add(scheduledIntDTO);
        }
        return new ResponseEntity<>(scheduledInterviews,HttpStatus.OK);
    }
}
