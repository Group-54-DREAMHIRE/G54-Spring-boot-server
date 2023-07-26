package com.dreamhire.DreamHire.dto;

import com.dreamhire.DreamHire.model.SystemUser;
import com.dreamhire.DreamHire.model.UserType;
import lombok.Data;

@Data
public class RegisterDto {
    private String email;
    private String password;
    private UserType userType;
}
