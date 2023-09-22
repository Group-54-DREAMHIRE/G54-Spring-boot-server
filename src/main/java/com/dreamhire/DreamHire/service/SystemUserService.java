package com.dreamhire.DreamHire.service;

import com.dreamhire.DreamHire.dto.ChangePasswordDTO;
import com.dreamhire.DreamHire.dto.RegisterDto;
import com.dreamhire.DreamHire.model.Candidate;
import com.dreamhire.DreamHire.model.Company;
import com.dreamhire.DreamHire.model.SystemUser;
import com.dreamhire.DreamHire.repository.CandidateRepo;
import com.dreamhire.DreamHire.repository.CompanyRepo;
import com.dreamhire.DreamHire.repository.SystemUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SystemUserService {
    @Autowired
    private SystemUserRepo systemUserRepo;
    @Autowired
    private CandidateRepo candidateRepo;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerSystemUser(RegisterDto register) {
        if (systemUserRepo.existsByEmail(register.getEmail())) {
            return "bad";
        } else if(register.getUserType().toString().equals("admin")){
            return "reject";
        }
        else {
            SystemUser user = new SystemUser();
            user.setEmail(register.getEmail());
            user.setPassword(passwordEncoder.encode(register.getPassword()));
            user.setUserType(register.getUserType());
            systemUserRepo.save(user);
            if(register.getUserType().toString()=="candidate"){
                Candidate candidate = new Candidate();
                candidate.setSystemUser(systemUserRepo.findByEmail(register.getEmail()).get());
                candidateRepo.save(candidate);
            }
            if(register.getUserType().toString()=="company"){
                Company company = new Company();
                company.setSystemUser(systemUserRepo.findByEmail(register.getEmail()).get());
                companyRepo.save(company);

            }
            return "User is registered successfully";
        }
    }

    public String changeUserPassword(ChangePasswordDTO changePasswordDTO){

        if(!systemUserRepo.existsByEmail(changePasswordDTO.getEmail())){
            return "bad";
        }else {
            SystemUser user = systemUserRepo.findByEmail(changePasswordDTO.getEmail()).get();
            user.setPassword(passwordEncoder.encode(changePasswordDTO.getNewPassword()));
            systemUserRepo.save(user);
            return "Password is changed successfully";
        }
    }
}
