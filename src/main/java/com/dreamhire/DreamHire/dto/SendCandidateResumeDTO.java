package com.dreamhire.DreamHire.dto;

import lombok.Data;

@Data
public class SendCandidateResumeDTO {
    private String candidateName;
    private String candidateCity;
    private String currency;
    private String expectSalary;
    private String tags;
    private String title;
    private int canID;

}
