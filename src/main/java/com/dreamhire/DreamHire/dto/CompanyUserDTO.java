package com.dreamhire.DreamHire.dto;

import lombok.Data;

@Data
public class CompanyUserDTO {

    private int id;
    private String name;
    private String email;
    private String password;
    private String role;
}
