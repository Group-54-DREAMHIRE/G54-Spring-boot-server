package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.ApplyEventDTO;
import com.dreamhire.DreamHire.dto.ApplyJobDTO;
import com.dreamhire.DreamHire.model.ApplyEventCandidate;
import com.dreamhire.DreamHire.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
