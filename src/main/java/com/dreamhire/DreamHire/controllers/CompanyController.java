package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.CompanyDataDTO;
import com.dreamhire.DreamHire.dto.RegistrationDTO;
import com.dreamhire.DreamHire.model.Candidate;
import com.dreamhire.DreamHire.model.Company;
import com.dreamhire.DreamHire.model.JobPost;
import com.dreamhire.DreamHire.repository.CompanyRepo;
import com.dreamhire.DreamHire.repository.SystemUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("api/v1/company")
public class CompanyController {
    @Autowired
    SystemUserRepo systemUserRepo;
    @Autowired
    CompanyRepo companyRepo;

   @PostMapping("/save/{id}")
    public ResponseEntity<?> saveCompany(@PathVariable int id, @RequestBody CompanyDataDTO companyData){
        if(companyRepo.existsById(id)){
            Company company = companyRepo.findById(id);
           company.setName(companyData.getName());
           company.setLogo(companyData.getLogo());
           company.setImages(companyData.getImages());
           company.setDescription(companyData.getDescription());
           company.setAbout(companyData.getAbout());
           company.setServices(companyData.getServices());
           company.setServiceKeys(companyData.getServiceKeys());
           company.setVisible(companyData.isVisible());
           company.setPhone(companyData.getPhone());
           company.setAddress(companyData.getAddress());
           company.setEmail(companyData.getEmail());
           company.setFacebook(companyData.getFacebook());
           company.setTwitter(companyData.getTwitter());
           company.setLinkedIn(companyData.getLinkedIn());
           companyRepo.save(company);
            return new ResponseEntity<>(company, HttpStatus.OK);
        }
       return new ResponseEntity<>("Data is invalid", HttpStatus.BAD_REQUEST);
   }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCompany(@PathVariable int id){
        if(companyRepo.existsById(id)){
            Company company = companyRepo.findById(id);
            return ResponseEntity.ok(company);
        }else {
            return new ResponseEntity<>("User details is invalid",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getAllCompanies")
    public ResponseEntity<List> getAllCompanies(){
       List <Company> companies = companyRepo.getAllApprovedVisibleCompanies();
       return new ResponseEntity<List>(companies, HttpStatus.OK);
    }

    @PostMapping("/saveBR/{id}")
    public ResponseEntity<?> saveBR(@PathVariable int id, @RequestBody RegistrationDTO registration){
       if(companyRepo.existsById(id)){
           Company company = companyRepo.findById(id);
           company.setRegistration(registration.getRegistration());
           companyRepo.save(company);
           return new ResponseEntity<>("Register is successfully", HttpStatus.OK);
       }else {
           return new ResponseEntity<>("Invalid Data!", HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("/getPendingApprovals")
    public ResponseEntity<?> getPendingApprovalList(){
       List <Company> company = companyRepo.getPendingApprovalList();
       return new ResponseEntity<>(company, HttpStatus.OK);
    }

}
