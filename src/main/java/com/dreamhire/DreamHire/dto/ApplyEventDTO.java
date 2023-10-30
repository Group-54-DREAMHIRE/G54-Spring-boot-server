package com.dreamhire.DreamHire.dto;

import lombok.Data;

@Data
public class ApplyEventDTO {
    private int eventID;
    private String candidateName;
    private String candidatePhone;
    private String candidateEmail;
    private String candidateAddress;
}
