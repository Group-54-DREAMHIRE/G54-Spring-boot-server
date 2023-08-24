package com.dreamhire.DreamHire.dto;

import lombok.Data;

@Data
public class ApplyJobDTO {
    private int jobID;
    private String candidateName;
    private String candidatePhone;
    private String candidateEmail;
    private String candidateCity;
    private String currency;
    private String expectSalary;
    private String tags;
}