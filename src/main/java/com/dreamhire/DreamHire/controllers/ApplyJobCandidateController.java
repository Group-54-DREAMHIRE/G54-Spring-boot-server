package com.dreamhire.DreamHire.controllers;
import com.dreamhire.DreamHire.dto.ApplyJobDTO;
import com.dreamhire.DreamHire.dto.CanselJobDTO;
import com.dreamhire.DreamHire.dto.CanStatusRequestDTO;
import com.dreamhire.DreamHire.dto.SendMailStatusDTO;
import com.dreamhire.DreamHire.model.ApplyJobCandidate;
import com.dreamhire.DreamHire.model.CandidateType;
import com.dreamhire.DreamHire.repository.ApplyJobCandidateRepo;
import com.dreamhire.DreamHire.repository.CandidateRepo;
import com.dreamhire.DreamHire.repository.JobPostRepo;
import com.dreamhire.DreamHire.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/applyjobcandidate")
public class ApplyJobCandidateController {

    @Autowired
    private JobPostRepo jobPostRepo;
    @Autowired
    private CandidateRepo candidateRepo;
    @Autowired
    private ApplyJobCandidateRepo applyJobCandidateRepo;
    @Autowired
    private EmailService emailService;

    @PostMapping(path = "/save/{id}")
    public ResponseEntity<?> saveApplyJobCandidate(@PathVariable int id, @RequestBody ApplyJobDTO applyJob){
        ApplyJobCandidate applyJobCandidate = new ApplyJobCandidate(applyJob);
        applyJobCandidate.setAppliedDate(new Date());
        applyJobCandidate.setCandidateType(CandidateType.pending);
        applyJobCandidate.setJobPost(jobPostRepo.findById(applyJob.getJobID()));
        applyJobCandidate.setCandidate(candidateRepo.findById(id));
        applyJobCandidateRepo.save(applyJobCandidate);
        SendMailStatusDTO sendMailStatusDTO = new SendMailStatusDTO();
        sendMailStatusDTO.setJobTitle(applyJobCandidate.getJobTitle());
        sendMailStatusDTO.setCompanyName(applyJobCandidate.getJobPost().getCompanyName());
        sendMailStatusDTO.setEmail(applyJobCandidate.getCandidateEmail());
        sendMailStatusDTO.setCanName(applyJobCandidate.getCandidateName());
//        String response = emailService.sendApplyMail(sendMailStatusDTO);
//        System.out.println(response);
        return new ResponseEntity<>("Apply is successfully", HttpStatus.OK);
    }

    @GetMapping(path = "/getPendingCandidates/{id}")
    public ResponseEntity<?> getPendingCandidates(@PathVariable int id){
        if(jobPostRepo.existsById(id)){
            List <ApplyJobCandidate> applyJobCandidate = applyJobCandidateRepo.getPendingResumes(id);
            return new ResponseEntity<>(applyJobCandidate, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("There is no job post given id", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(path = "/getShortListedCandidates/{id}")
    public ResponseEntity<?> getShortListCandidates(@PathVariable int id){
        if(jobPostRepo.existsById(id)){
            List <ApplyJobCandidate> applyJobCandidate = applyJobCandidateRepo.getShortListResumes(id);
            return new ResponseEntity<>(applyJobCandidate, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("There is no job post given id", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(path = "/getRejectedCandidates/{id}")
    public ResponseEntity<?> getRejectedCandidates(@PathVariable int id){
        if(jobPostRepo.existsById(id)){
            List <ApplyJobCandidate> applyJobCandidate = applyJobCandidateRepo.getRejectedResumes(id);
            return new ResponseEntity<>(applyJobCandidate, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("There is no job post given id", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(path = "/getCanceledCandidates/{id}")
    public ResponseEntity<?> getCanceledCandidates(@PathVariable int id){
        if(jobPostRepo.existsById(id)){
            List <ApplyJobCandidate> applyJobCandidate = applyJobCandidateRepo.getCanceledResumes(id);
            return new ResponseEntity<>(applyJobCandidate, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("There is no job post given id", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(path = "/getAppliedJobs/{id}")
    public ResponseEntity<?> getAppliedJobs(@PathVariable int id){
        if(candidateRepo.existsById(id)){
           List <ApplyJobCandidate> applyJobCandidate = applyJobCandidateRepo.getApplyJobCandidateByCandidateId(id);
           return new ResponseEntity<>(applyJobCandidate,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/cansel/{id}")
    public ResponseEntity<?> canselJob(@PathVariable int id, @RequestBody CanselJobDTO canselJobDTO){
        if(candidateRepo.existsById(id)){
            int jobId = canselJobDTO.getJobId();
            ApplyJobCandidate applyJobCandidate = applyJobCandidateRepo.findByCandidateAndJobPostId(id,jobId);
            applyJobCandidate.setCandidateType(CandidateType.valueOf("cancel"));
            applyJobCandidate.setReason(canselJobDTO.getReason());
            applyJobCandidate.setAppliedDate(new Date());
            applyJobCandidateRepo.save(applyJobCandidate);
            return new ResponseEntity<>("Success",HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @PostMapping(path = "/reject")
    public ResponseEntity<?> addToRejectList(@RequestBody CanStatusRequestDTO canStatusRequestDTO){
       try{
           ApplyJobCandidate applyJobCandidate = applyJobCandidateRepo.findByCandidateAndJobPostId(canStatusRequestDTO.getCanId(), canStatusRequestDTO.getJobId());
           applyJobCandidate.setCandidateType(CandidateType.reject);
           applyJobCandidate.setAppliedDate(new Date());
           applyJobCandidateRepo.save(applyJobCandidate);
           SendMailStatusDTO sendMailStatusDTO = new SendMailStatusDTO();
           sendMailStatusDTO.setJobTitle(applyJobCandidate.getJobTitle());
           sendMailStatusDTO.setCompanyName(applyJobCandidate.getJobPost().getCompanyName());
           sendMailStatusDTO.setEmail(applyJobCandidate.getCandidateEmail());
           sendMailStatusDTO.setCanName(applyJobCandidate.getCandidateName());
//           String response = emailService.rejectMail(sendMailStatusDTO);
//           System.out.println(response);
           return new ResponseEntity<>("success", HttpStatus.OK);
       }catch (Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }

    }

    @PostMapping(path = "/shortlist")
    public ResponseEntity<?> addToShortList(@RequestBody CanStatusRequestDTO canStatusRequestDTO){
        try{
            ApplyJobCandidate applyJobCandidate = applyJobCandidateRepo.findByCandidateAndJobPostId(canStatusRequestDTO.getCanId(), canStatusRequestDTO.getJobId());
            applyJobCandidate.setCandidateType(CandidateType.shortlist);
            applyJobCandidate.setAppliedDate(new Date());
            applyJobCandidateRepo.save(applyJobCandidate);
            SendMailStatusDTO sendMailStatusDTO = new SendMailStatusDTO();
            sendMailStatusDTO.setJobTitle(applyJobCandidate.getJobTitle());
            sendMailStatusDTO.setCompanyName(applyJobCandidate.getJobPost().getCompanyName());
            sendMailStatusDTO.setEmail(applyJobCandidate.getCandidateEmail());
            sendMailStatusDTO.setCanName(applyJobCandidate.getCandidateName());
//            String response = emailService.sendShortlistMail(sendMailStatusDTO);
//            System.out.println(response);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(path = "/pending")
    public ResponseEntity<?> addToPendingList(@RequestBody CanStatusRequestDTO canStatusRequestDTO){
        try{
            ApplyJobCandidate applyJobCandidate = applyJobCandidateRepo.findByCandidateAndJobPostId(canStatusRequestDTO.getCanId(), canStatusRequestDTO.getJobId());
            applyJobCandidate.setCandidateType(CandidateType.pending);
            applyJobCandidateRepo.save(applyJobCandidate);
            applyJobCandidate.setAppliedDate(new Date());
            return new ResponseEntity<>("success", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
