package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.JobPostDTO;
import com.dreamhire.DreamHire.dto.PostedJobsDTO;
import com.dreamhire.DreamHire.model.JobPost;
import com.dreamhire.DreamHire.repository.CompanyRepo;
import com.dreamhire.DreamHire.repository.CustomDataRepo;
import com.dreamhire.DreamHire.repository.JobPostRepo;
import com.dreamhire.DreamHire.repository.SystemUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/jobpost")
public class JobPostController {

    @Autowired
    private SystemUserRepo systemUserRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private JobPostRepo jobPostRepo;

    @Autowired
    private CustomDataRepo customDataRepo;

    @PostMapping("/save/{id}")
    public ResponseEntity<?> addJobPost (@PathVariable int id, @RequestBody JobPostDTO post){
            JobPost jobPost = new JobPost();
            jobPost.setAuthor(systemUserRepo.findById(post.getSystemUserID()).get().getEmail());
            jobPost.setCompanyName(post.getCompanyName());
            jobPost.setPostedDate(post.getPostedDate());
            jobPost.setCover(post.getCover());
            jobPost.setCurrency(post.getCurrency());
            jobPost.setNumberOfVacancies(post.getNumberOfVacancies());
            jobPost.setMinSalary(post.getMinSalary());
            jobPost.setMaxSalary(post.getMaxSalary());
            jobPost.setJobTitle(post.getJobTitle());
            jobPost.setJobType(post.getJobType());
            jobPost.setExperience(post.getExperience());
            jobPost.setEducation(post.getEducation());
            jobPost.setDeadline(post.getDeadline());
            jobPost.setDescription(post.getDescription());
            jobPost.setHowToApply(post.getHowToApply());
            jobPost.setJobRequirements(post.getJobRequirements());
            jobPost.setTags(post.getTags());
            jobPost.setCompany(companyRepo.findById(id));
            jobPostRepo.save(jobPost);
            return new ResponseEntity<>(jobPost, HttpStatus.OK);

    }

    @GetMapping("/getalljobs")
    public ResponseEntity<List> getAllJobPosts(){
        List<JobPost> jobs = jobPostRepo.getAllValidateJobPosts();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping("/getjobpost/{id}")
    public ResponseEntity<?> getJobPost(@PathVariable int id){
        JobPost jobPost = jobPostRepo.findById(id);
        return new ResponseEntity<>(jobPost, HttpStatus.OK);
    }

    @GetMapping("/getAllJobsByCompanyId/{id}")
    public ResponseEntity<?> getAllJobsByCompanyId(@PathVariable int id){
        List<PostedJobsDTO> jobs = customDataRepo.getPostedJobsByCompanyId(id);
        System.out.println(jobs);
        return new ResponseEntity<>( jobs,HttpStatus.OK);
    }
}
