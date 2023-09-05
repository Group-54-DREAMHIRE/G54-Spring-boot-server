package com.dreamhire.DreamHire.dto;

import lombok.Data;

import java.util.Date;

@Data
public class InterviewDTO {
    private String type;
    private Date startTime;
    private int duration;
    private String withInt;
    private int jobId;
}
