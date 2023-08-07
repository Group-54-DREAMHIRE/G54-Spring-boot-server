package com.dreamhire.DreamHire.dto;

import lombok.Data;

import java.util.Date;

@Data

public class CandidateDataDTO {

    private int userId;
    private String email;
    private String name;
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
}
