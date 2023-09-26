package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.CandidateDataDTO;
import com.dreamhire.DreamHire.model.Candidate;

import com.dreamhire.DreamHire.model.Company;
import com.dreamhire.DreamHire.repository.CandidateRepo;
import com.dreamhire.DreamHire.repository.SystemUserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/candidate")
public class CandidateController {

    @Autowired
    private SystemUserRepo systemUserRepo;
    @Autowired
    private CandidateRepo candidateRepo;

   @PostMapping(path = "/save/{id}")
    public ResponseEntity<?> saveCandidate(@PathVariable int id, @RequestBody CandidateDataDTO data){
        if(candidateRepo.existsById(id)){
            Candidate candidate = candidateRepo.findById(id);
            candidate.setName(data.getName());
            candidate.setCurrency(data.getCurrency());
            candidate.setMinSalary(data.getMinSalary());
            candidate.setMaxSalary(data.getMaxSalary());
            candidate.setProfilePicture(data.getProfilePicture());
            candidate.setVisible(data.isVisible());
            candidate.setTitle(data.getTitle());
            candidate.setBirthday(data.getBirthday());
            candidate.setDescription(data.getDescription());
            candidate.setPhone(data.getPhone());
            candidate.setCity(data.getCity());
            candidate.setEmail(data.getEmail());
            candidate.setPhone(data.getPhone());
            candidate.setAddress(data.getAddress());
            candidate.setFacebook(data.getFacebook());
            candidate.setTwitter(data.getTwitter());
            candidate.setLinkedIn(data.getLinkedIn());
            candidateRepo.save(candidate);
            return new ResponseEntity<>(candidate, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Data is invalid", HttpStatus.BAD_REQUEST);
        }

   }

   @GetMapping(path = "/get/{id}")
    public ResponseEntity<?> getCandidate(@PathVariable int id){
       if(candidateRepo.existsById(id)){
           Candidate candidate = candidateRepo.findById(id);
           return ResponseEntity.ok(candidate);
       }else {
           return new ResponseEntity<>("User details is invalid",HttpStatus.BAD_REQUEST);
       }
   }

    @GetMapping(path = "/getAllCandidates")
    public ResponseEntity<List> getAllCandidates(){
        List <Candidate> candidates = candidateRepo.getAllVisibleCandidates();
        return new ResponseEntity<List>(candidates, HttpStatus.OK);
    }
}
