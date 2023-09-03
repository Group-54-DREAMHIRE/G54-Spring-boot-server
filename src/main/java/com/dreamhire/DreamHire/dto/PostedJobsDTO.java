package com.dreamhire.DreamHire.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostedJobsDTO {

    private String jobTitle;
    private String tags;
    private boolean validate;
    private Date deadline;
    private int jobPostId;
    private int numberOfApplicants;
    private int numberOfVacancies;


    public void setJobPostId(int jobPostId) {
        this.jobPostId = jobPostId;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public void setNumberOfVacancies(int numberOfVacancies) {
        this.numberOfVacancies = numberOfVacancies;
    }

    public void setNumberOfApplicants(int numberOfApplicants) {
        this.numberOfApplicants = numberOfApplicants;
    }

}


