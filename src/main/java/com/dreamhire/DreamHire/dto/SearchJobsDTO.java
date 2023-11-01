package com.dreamhire.DreamHire.dto;

import lombok.Data;

@Data
public class SearchJobsDTO {
    private String jobTitle;
    private String jobType;
    private String salary;
    private String experience;
}
