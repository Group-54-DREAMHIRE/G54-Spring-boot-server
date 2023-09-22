package com.dreamhire.DreamHire.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ScheduledIntDTO {
    private int id;
    private String companyName;
    private Date startTime;
    private int duration;
    private String intWith;
    private String type;
    private String report;
}
