package com.dreamhire.DreamHire.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;
import java.util.Date;

@Data
public class EventDTO {
    private int companyID;
    private String companyName;
    private String author;
    private String title;
    private String description;
    private String cover;
    private String companies;
    private Date date;
    private Date postedDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String email;
    private String phone;
}
