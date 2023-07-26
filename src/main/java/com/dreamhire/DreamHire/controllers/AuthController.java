package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.AuthResponseDTO;
import com.dreamhire.DreamHire.dto.LoginDto;
import com.dreamhire.DreamHire.dto.RegisterDto;
import com.dreamhire.DreamHire.model.SystemUser;
import com.dreamhire.DreamHire.model.UserType;
import com.dreamhire.DreamHire.repository.SystemUserRepository;
import com.dreamhire.DreamHire.security.JWTGenerator;
import com.dreamhire.DreamHire.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

    @Autowired
    private SystemUserService systemUserService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private SystemUserRepository systemUserRepository;
    @Autowired
    private JWTGenerator jwtGenerator;


    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);
        SystemUser user = systemUserRepository.findByEmail(loginDto.getEmail()).get();
        return new ResponseEntity<>(new AuthResponseDTO(token, user ), HttpStatus.OK);
    }

    @PostMapping("register")
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
