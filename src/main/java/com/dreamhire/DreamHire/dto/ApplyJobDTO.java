package com.dreamhire.DreamHire.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ApplyJobDTO {
    private int jobID;
    private Date appliedDate;
    private String candidateName;
    private String candidatePhone;
    private String candidateEmail;
    private String candidateCity;
    private String tags;
    private String jobTitle;
}
