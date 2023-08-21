package com.dreamhire.DreamHire.dto;

import lombok.Data;

import java.util.Date;

@Data

public class CandidateDataDTO {

    private String email;
    private String name;
    private boolean visible;
    private Date birthday;
    private String profilePicture;
    private String title;
    private String description;
    private String phone;
    private String address;
    private String city;
    private String facebook;
    private String twitter;
    private String linkedIn;
    private String currency;
    private String minSalary;
    private String maxSalary;
}
