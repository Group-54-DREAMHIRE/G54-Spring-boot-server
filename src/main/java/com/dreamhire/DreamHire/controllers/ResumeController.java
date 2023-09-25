package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.ProfileDTO;
import com.dreamhire.DreamHire.model.Resume;
import com.dreamhire.DreamHire.repository.CandidateRepo;
import com.dreamhire.DreamHire.repository.ResumeRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/resume")
public class ResumeController {

    @Autowired
    private CandidateRepo candidateRepo;

    @Autowired
    private ResumeRepo resumeRepo;

    @PostMapping(path = "/save/{id}")
    public ResponseEntity<?> saveResume(@PathVariable int id, @RequestBody List<Object> data) throws JsonProcessingException {
            ObjectMapper objectMapper = new ObjectMapper();
            Resume resume = new Resume(getResume(id));
            resume.setProfile(objectMapper.writeValueAsString(data.get(0)));
            resume.setEducation(objectMapper.writeValueAsString(data.get(1)));
            resume.setProfessionalExperience(objectMapper.writeValueAsString(data.get(2)));
            resume.setProjects(objectMapper.writeValueAsString(data.get(3)));
            resume.setCoursesCertifications(objectMapper.writeValueAsString(data.get(4)));
            resume.setSkills(objectMapper.writeValueAsString(data.get(5)));
            resume.setVolunteerExperience(objectMapper.writeValueAsString(data.get(6)));
            resume.setOtherQualification(objectMapper.writeValueAsString(data.get(7)));
            resume.setReference(objectMapper.writeValueAsString(data.get(8)));
            resumeRepo.save(resume);

        return new ResponseEntity<>(resume, HttpStatus.OK);
    }

    @PostMapping(path = "/saveprofile/{id}")
    public ResponseEntity<?> saveProfile(@PathVariable int id, @RequestBody ProfileDTO profileDTO){
        Resume resume = new Resume(getResume(id));
        resume.setName(profileDTO.getName());
        resume.setProfilePicture(profileDTO.getProfilePicture());
        resume.setPhone(profileDTO.getPhone());
        resume.setJobTitle(profileDTO.getJobTitle());
        resume.setEmail(profileDTO.getEmail());
        resume.setAddress(profileDTO.getAddress());
        resume.setLinkedInLabel(profileDTO.getLinkedInLabel());
        resume.setTwitterLabel(profileDTO.getTwitterLabel());
        resume.setGithubLabel(profileDTO.getGithubLabel());
        resume.setWebsiteLabel(profileDTO.getWebsiteLabel());
        resume.setDiscordLabel(profileDTO.getDiscordLabel());
        resume.setLinkedIn(profileDTO.getLinkedIn());
        resume.setTwitter(profileDTO.getTwitter());
        resume.setGithub(profileDTO.getGithub());
        resume.setWebsite(profileDTO.getWebsite());
        resume.setDiscord(profileDTO.getDiscord());
        resumeRepo.save(resume);
        return new ResponseEntity<>(resume, HttpStatus.OK);
    }

    public Resume getResume(int id){
        if(resumeRepo.existsByCandidateId(id)){
            return resumeRepo.findByCandidateId(id);
        }else{
            Resume resume =  new Resume();
            resume.setCandidate(candidateRepo.findById(id));
            resume.setHasResume(true);
            return resume;
        }
    }

    @GetMapping(path = "/getResume/{id}")
    public ResponseEntity<?> getCandidateResume(@PathVariable int id){
        if(resumeRepo.existsByCandidateId(id)){
            return new ResponseEntity<>(resumeRepo.findByCandidateId(id), HttpStatus.OK);
        }else{
           return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }
}
