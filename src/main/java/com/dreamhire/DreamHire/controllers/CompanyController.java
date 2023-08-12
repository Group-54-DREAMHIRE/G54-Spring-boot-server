package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.CompanyDataDTO;
import com.dreamhire.DreamHire.model.Candidate;
import com.dreamhire.DreamHire.model.Company;
import com.dreamhire.DreamHire.repository.CompanyRepo;
import com.dreamhire.DreamHire.repository.SystemUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@CrossOrigin
@RestController
@RequestMapping("api/v1/company")
public class CompanyController {
    @Autowired
    SystemUserRepo systemUserRepo;
    @Autowired
    CompanyRepo companyRepo;

   @PostMapping("/save/{id}")
    public ResponseEntity<String> saveCompany(@PathVariable int id, @RequestBody CompanyDataDTO companyData){
        if(companyRepo.existsById(id)){
            Company company = companyRepo.findById(id);
           company.setName(companyData.getName());
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
        }
       return new ResponseEntity<>("Successfully updated", HttpStatus.OK);
   }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCandidate(@PathVariable int id){
        if(companyRepo.existsById(id)){
            Company company = companyRepo.findById(id);
            return ResponseEntity.ok(company);
        }else {
            return new ResponseEntity<>("User details is invalid",HttpStatus.BAD_REQUEST);
        }
    }
}
