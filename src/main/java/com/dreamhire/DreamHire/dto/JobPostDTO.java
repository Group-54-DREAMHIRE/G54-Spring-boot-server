package com.dreamhire.DreamHire.dto;

import lombok.Data;

import java.util.Date;

@Data
public class JobPostDTO {
    private String companyName;
    private Date postedDate;
    private String jobTitle;
    private String jobType;
    private String experience;
    private String education;
    private Date deadline;
    private String description;
    private String howToApply;
    private String jobRequirements;
    private String tags;
    private String cover;
    private int systemUserID;
    private String currency;
    private String minSalary;
    private String maxSalary;
    private int numberOfVacancies;

}
