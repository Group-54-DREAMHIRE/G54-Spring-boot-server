package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.GetTestDTO;
import com.dreamhire.DreamHire.dto.TestDTO;
import com.dreamhire.DreamHire.model.Resume;
import com.dreamhire.DreamHire.model.SelectionTest;
import com.dreamhire.DreamHire.repository.CompanyRepo;
import com.dreamhire.DreamHire.repository.JobPostRepo;
import com.dreamhire.DreamHire.repository.SelectionTestRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/test")
public class TestController {

    @Autowired
    private SelectionTestRepo selectionTestRepo;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private JobPostRepo jobPostRepo;

    @PostMapping("/save/{id}")
    public ResponseEntity<?> saveTest(@PathVariable int id, @RequestBody TestDTO testDTO) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        SelectionTest selectionTest = new SelectionTest(testDTO);
        selectionTest.setCompany(companyRepo.findById(id));
        selectionTest.setJobPost(jobPostRepo.findById(testDTO.getJobId()));
        selectionTest.setQuestions(objectMapper.writeValueAsString(testDTO.getQuestions()));
        selectionTestRepo.save(selectionTest);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("/getTests/{id}")
    public ResponseEntity<?> getTests(@PathVariable int id){
        List<SelectionTest> tests = selectionTestRepo.findByCompanyId(id);
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }

    @GetMapping("/getTest/{id}")
    public ResponseEntity<?> getTest(@PathVariable int id){
        SelectionTest test = selectionTestRepo.findById(id);
        return new ResponseEntity<>(test, HttpStatus.OK);
    }

    @GetMapping("/getSchedulesTests/{id}")
    public ResponseEntity<?> getScheduledTest(@PathVariable int id){
        List<SelectionTest> test = selectionTestRepo.findAllByJobPostId(id);
        return new ResponseEntity<>(test, HttpStatus.OK);
    }


}
