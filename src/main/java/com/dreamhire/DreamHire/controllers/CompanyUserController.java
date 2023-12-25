package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.CompanyUserDTO;
import com.dreamhire.DreamHire.model.CompanyUser;
import com.dreamhire.DreamHire.repository.CompanyRepo;
import com.dreamhire.DreamHire.repository.CompanyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/companyUsers")
public class CompanyUserController {

    @Autowired
    private CompanyUserRepo companyUserRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @PostMapping("/save/{id}")
    public ResponseEntity<?> saveUser(@PathVariable int id, @RequestBody CompanyUserDTO companyUserDTO){
        CompanyUser companyUser = new CompanyUser(companyUserDTO);
        companyUser.setCompany(companyRepo.findById(id));
        companyUserRepo.save(companyUser);
        return new ResponseEntity<>(companyUser, HttpStatus.OK);

    }

    @GetMapping("/getUsers/{id}")
    public ResponseEntity<?> getUsers(@PathVariable int id){
        List<CompanyUser>  users = companyUserRepo.findAllByCompanyId(id);
        return new ResponseEntity<>(users, HttpStatus.OK);

    }


}
