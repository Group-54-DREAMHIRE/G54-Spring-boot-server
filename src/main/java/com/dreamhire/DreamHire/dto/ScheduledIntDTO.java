package com.dreamhire.DreamHire.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ScheduledIntDTO {
    private int intId;
    private String companyName;
    private Date startTime;
    private int duration;
    private String intWith;
    private String type;
    private String report;
}
