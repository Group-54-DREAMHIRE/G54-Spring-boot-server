package com.dreamhire.DreamHire.service;

import com.dreamhire.DreamHire.dto.ChangePasswordDTO;
import com.dreamhire.DreamHire.dto.RegisterDto;
import com.dreamhire.DreamHire.model.SystemUser;
import com.dreamhire.DreamHire.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SystemUserService {
    @Autowired
    private SystemUserRepository systemUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerSystemUser(RegisterDto register) {
        if (systemUserRepository.existsByEmail(register.getEmail())) {
            return "bad";
        } else if(register.getUserType().toString().equals("admin")){
            return "reject";
        }
        else {
            SystemUser user = new SystemUser();
            user.setEmail(register.getEmail());
            user.setPassword(passwordEncoder.encode(register.getPassword()));
            user.setUserType(register.getUserType());
            systemUserRepository.save(user);
            return "User is registered successfully";
        }
    }

    public String changeUserPassword(ChangePasswordDTO changePasswordDTO){

        if(!systemUserRepository.existsByEmail(changePasswordDTO.getEmail())){
            return "bad";
        }else {
            SystemUser user = new SystemUser();
            user.setPassword(passwordEncoder.encode(changePasswordDTO.getNewPassword()));
            systemUserRepository.save(user);
            return "Password is changed successfully";
        }
    }
}
