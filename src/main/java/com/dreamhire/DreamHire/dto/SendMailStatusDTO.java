package com.dreamhire.DreamHire.dto;

import lombok.Data;

@Data
public class SendMailStatusDTO {
    private String email;
    private String companyName;
    private String jobTitle;
    private String canName;
}
