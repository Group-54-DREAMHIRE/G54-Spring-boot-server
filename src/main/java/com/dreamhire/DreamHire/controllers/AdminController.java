package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.model.Admin;
import com.dreamhire.DreamHire.model.Company;
import com.dreamhire.DreamHire.repository.AdminRepo;
import com.dreamhire.DreamHire.repository.CompanyRepo;
import com.dreamhire.DreamHire.repository.SystemUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/admin")
public class AdminController {

    @Autowired
    SystemUserRepo systemUserRepo;
    @Autowired
    AdminRepo adminRepo;
    @Autowired
    CompanyRepo companyRepo;

    @PostMapping(path = "/save/{id}")
    public ResponseEntity<?> saveAdmin(@PathVariable int id, @RequestBody Admin admin) {
        if (adminRepo.existsById(id)) {
            Admin admin1 = adminRepo.findById(id);
            admin1.setEmail(admin.getEmail());
            admin1.setPhone(admin.getPhone());
            admin1.setName(admin.getName());
            admin1.setProfilePicture(admin.getProfilePicture());
            adminRepo.save(admin1);
            return new ResponseEntity<>(admin1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Data is invalid", HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(path = "/approve/company/{id}")
    public ResponseEntity<String> approveCompany(@PathVariable int id, @RequestBody String approve){
        if(companyRepo.existsById(id)){
            Company company = companyRepo.findById(id);
            company.setApproval(true);
            companyRepo.save(company);
            return new ResponseEntity<>("Approved Successfully", HttpStatus.OK);
        }else return new ResponseEntity<>("Invalid Data", HttpStatus.BAD_REQUEST);
    }
    @PostMapping(path = "/reject/company/{id}")
    public ResponseEntity<String> rejectCompany(@PathVariable int id, @RequestBody String reject){
        if(companyRepo.existsById(id)){
            Company company = companyRepo.findById(id);
            company.setReject(true);
            companyRepo.save(company);
            return new ResponseEntity<>("Rejected Successfully", HttpStatus.OK);
        }else return new ResponseEntity<>("Invalid Data", HttpStatus.BAD_REQUEST);
    }
}
