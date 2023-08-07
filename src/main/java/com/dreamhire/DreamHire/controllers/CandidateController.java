package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.CandidateDataDTO;
import com.dreamhire.DreamHire.model.Candidate;
import com.dreamhire.DreamHire.model.SystemUser;
import com.dreamhire.DreamHire.repository.CandidateRepo;
import com.dreamhire.DreamHire.repository.SystemUserRepo;
import com.dreamhire.DreamHire.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("api/v1/candidate")
public class CandidateController {

    @Autowired
    private SystemUserRepo systemUserRepo;
    @Autowired
    private CandidateRepo candidateRepo;

   @PostMapping("/save/{id}")
    public ResponseEntity<String> saveCandidate(@PathVariable int id, @RequestBody CandidateDataDTO data){
        if(candidateRepo.existsById(id)){
            Candidate candidate = candidateRepo.findById(id);
            candidate.setName(data.getName());
            candidate.setProfilePicture(data.getProfilePicture());
            candidate.setTitle(data.getTitle());
            candidate.setBirthday(data.getBirthday());
            candidate.setDescription(data.getDescription());
            candidate.setPhone(data.getPhone());
            candidate.setCity(data.getCity());
            candidate.setEmail(data.getEmail());
            candidate.setPhone(data.getPhone());
            candidate.setFacebook(data.getFacebook());
            candidate.setTwitter(data.getTwitter());
            candidate.setLinkedIn(data.getLinkedIn());
            candidateRepo.save(candidate);
        }else {
            Candidate candidate = new Candidate(data);
            candidate.setSystemUser(systemUserRepo.findById(data.getUserId()).get());
            candidateRepo.save(candidate);

        }
       return new ResponseEntity<>("Successfully updated", HttpStatus.OK);
   }


}
