package com.dreamhire.DreamHire.dto;

import lombok.Data;

@Data
public class ChangePasswordDTO {
    private String oldpassword;
    private String newpassword;
}
