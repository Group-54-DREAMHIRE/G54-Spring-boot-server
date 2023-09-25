package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.*;
import com.dreamhire.DreamHire.model.Admin;
import com.dreamhire.DreamHire.model.Candidate;
import com.dreamhire.DreamHire.model.Company;
import com.dreamhire.DreamHire.model.SystemUser;
import com.dreamhire.DreamHire.repository.AdminRepo;
import com.dreamhire.DreamHire.repository.CandidateRepo;
import com.dreamhire.DreamHire.repository.CompanyRepo;
import com.dreamhire.DreamHire.repository.SystemUserRepo;
import com.dreamhire.DreamHire.security.JWTGenerator;
import com.dreamhire.DreamHire.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/auth/")
public class AuthController {

    @Autowired
    private SystemUserService systemUserService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private SystemUserRepo systemUserRepo;
    @Autowired
    private CandidateRepo candidateRepo;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private JWTGenerator jwtGenerator;


    @PostMapping(path = "login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(loginDto.getEmail());
        String userType = systemUserRepo.findByEmail(loginDto.getEmail()).get().getUserType().toString();
        if(userType == "candidate"){
            Candidate candidate = candidateRepo.findBySystemUserId(systemUserRepo.findByEmail(loginDto.getEmail()).get().getId());
            return ResponseEntity.ok(new SendCandidateDTO(candidate,token, userType));
        }
        if(userType == "company"){
            Company company = companyRepo.findBySystemUserId(systemUserRepo.findByEmail(loginDto.getEmail()).get().getId());
            return ResponseEntity.ok(new SendCompanyDTO(company,token, userType));
        }
        if(userType == "admin"){
            Admin admin = adminRepo.findBySystemUserId(systemUserRepo.findByEmail(loginDto.getEmail()).get().getId());
            return ResponseEntity.ok(new SendAdminDTO(admin,token, userType));
        }
        return new ResponseEntity<>("User Data is invalid", HttpStatus.BAD_REQUEST);


    }

    @PostMapping(path = "register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        String res = systemUserService.registerSystemUser(registerDto);
        if (res.equals("bad")) {
            return new ResponseEntity<>("User is already registered!", HttpStatus.BAD_REQUEST);
        } else if (res.equals("reject")) {
            return new ResponseEntity<>("You are not allowed to register as an admin", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("User  is registered successfully!", HttpStatus.OK);
    }

}
