package com.dreamhire.DreamHire.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/v1/company")
public class CompanyController {

    @GetMapping("/get")
    public ResponseEntity<String> get(){
        return new ResponseEntity<>("Dula",HttpStatus.OK);
    }
}
