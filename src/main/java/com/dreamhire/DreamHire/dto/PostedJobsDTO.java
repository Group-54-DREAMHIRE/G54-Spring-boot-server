package com.dreamhire.DreamHire.dto;

import lombok.*;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostedJobsDTO {

    private int jobPostId;
    private String jobTitle;
    private String tags;
    private boolean validate;
    private Date deadline;
    private int numberOfVacancies;
    private BigInteger numberOfApplicants;


}


