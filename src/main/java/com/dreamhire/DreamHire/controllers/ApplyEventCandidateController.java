package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.ApplyEventDTO;
import com.dreamhire.DreamHire.dto.ApplyJobDTO;
import com.dreamhire.DreamHire.model.ApplyEventCandidate;
import com.dreamhire.DreamHire.model.ApplyJobCandidate;
import com.dreamhire.DreamHire.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/applyeventcandidate")
public class ApplyEventCandidateController {
    @Autowired
    private EventRepo eventRepo;
    @Autowired
    private CandidateRepo candidateRepo;
    @Autowired
    private ApplyEventCandidateRepo applyEventCandidateRepo;
    @PostMapping(path = "/save/{id}")
    public ResponseEntity<?> saveApplyEventCandidate(@PathVariable int id, @RequestBody ApplyEventDTO applyEvent){
        ApplyEventCandidate applyEventCandidate = new ApplyEventCandidate(applyEvent);
        applyEventCandidate.setEvent(eventRepo.findById(applyEvent.getEventID()));
        applyEventCandidate.setCandidate(candidateRepo.findById(id));
        applyEventCandidateRepo.save(applyEventCandidate);
        return new ResponseEntity<>("Apply is successful", HttpStatus.OK);
    }

    @GetMapping(path = "/getAppliedEvents/{id}")
    public ResponseEntity<?> getAppliedEvents(@PathVariable int id){
        if(candidateRepo.existsById(id)){
            List<ApplyEventCandidate> applyEventCandidate = applyEventCandidateRepo.getApplyEventCandidateByCandidateId(id);
            return new ResponseEntity<>(applyEventCandidate,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/getAppliedCandidates/{id}")
    public ResponseEntity<?> getAppliedCandidates(@PathVariable int id){
            List<ApplyEventCandidate> applyEventCandidate = applyEventCandidateRepo.getApplyEventCandidateByCandidateId(id);
            return new ResponseEntity<>(applyEventCandidate,HttpStatus.OK);
    }
}
