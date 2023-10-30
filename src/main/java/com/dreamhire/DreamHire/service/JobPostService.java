package com.dreamhire.DreamHire.service;

import com.dreamhire.DreamHire.dto.JobPostDTO;
import com.dreamhire.DreamHire.model.JobPost;
import com.dreamhire.DreamHire.repository.JobPostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class JobPostService {
    @Autowired
    private JobPostRepo jobPostRepo;
    @Autowired
    private ModelMapper modelMapper;

    public JobPostDTO updateJobPost(JobPostDTO jobPostDTO){
        jobPostRepo.save(modelMapper.map(jobPostDTO, JobPost.class));
        return jobPostDTO;
    }
}
