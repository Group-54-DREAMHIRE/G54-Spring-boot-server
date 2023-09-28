package com.dreamhire.DreamHire.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CanselJobDTO {
    private String reason;
    private int jobId;
    private Date canselDate;
}
