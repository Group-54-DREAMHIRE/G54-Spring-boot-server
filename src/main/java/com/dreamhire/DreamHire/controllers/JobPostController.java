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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/jobpost")
public class JobPostController {

    @Autowired
    private SystemUserRepo systemUserRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private JobPostRepo jobPostRepo;

    @Autowired
    private CustomDataRepo customDataRepo;

    @PostMapping(path = "/save/{id}")
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

    @GetMapping(path = "/getalljobs")
    public ResponseEntity<List> getAllJobPosts(){
        List<JobPost> jobs = jobPostRepo.getAllValidateJobPosts();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping(path = "/getjobpost/{id}")
    public ResponseEntity<?> getJobPost(@PathVariable int id){
        JobPost jobPost = jobPostRepo.findById(id);
        return new ResponseEntity<>(jobPost, HttpStatus.OK);
    }

    @GetMapping(path = "/getAllJobsByCompanyId/{id}")
    public ResponseEntity<?> getAllJobsByCompanyId(@PathVariable int id){
        List<JobPost> jobs = jobPostRepo.getJobPostsByCompanyId(id);
        System.out.println(jobs);
        return new ResponseEntity<>( jobs,HttpStatus.OK);
    }

    @GetMapping(path = "/getjobs/{id}")
    public ResponseEntity<?> getAllJobsByCompany(@PathVariable int id){
        List<Object[]> jobs = jobPostRepo.getJobs(id);
        List<PostedJobsDTO> postedJobs = new ArrayList<PostedJobsDTO>();
        System.out.println(jobs);
        for (Object[] job : jobs) {
            PostedJobsDTO postedJob = new PostedJobsDTO();
            postedJob.setJobPostId((int) job[0]);
            postedJob.setJobTitle((String) job[1]);
            postedJob.setTags((String) job[2]);
            postedJob.setValidate((boolean) job[3]);
            postedJob.setDeadline((Date) job[4]);
            postedJob.setNumberOfVacancies((int) job[5]);
            postedJob.setNumberOfApplicants((BigInteger) job[6]);
            postedJobs.add(postedJob);

        }
        return new ResponseEntity<>( postedJobs,HttpStatus.OK);
    }
}
