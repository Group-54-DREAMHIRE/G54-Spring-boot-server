package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.InterviewDTO;
import com.dreamhire.DreamHire.model.Interview;
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

@CrossOrigin
@RestController
@RequestMapping("api/v1/interview")
public class InterviewController {
    @Autowired
    private InterviewRepo interviewRepo;

    @Autowired
    private JobPostRepo jobPostRepo;

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
}
