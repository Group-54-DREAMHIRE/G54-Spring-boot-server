package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.ChangePasswordDTO;
import com.dreamhire.DreamHire.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/systemUser/")
public class SystemUserController {

    @Autowired
    private SystemUserService systemUserService;

    @PutMapping(path = "changePassword")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO){
        String res = systemUserService.changeUserPassword(changePasswordDTO);
        if(res.equals("bad")){
            return new ResponseEntity<>("Password is invalid! try again", HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
    }
}
