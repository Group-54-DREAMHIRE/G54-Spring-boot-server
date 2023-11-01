package com.dreamhire.DreamHire.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

@Data
public class TestDTO {
    private String title;
    private String instructions;
    private String type;
    private Date date;
    private int duration;
    private int passMark;
    private int numOfQuestions;
    @Column(columnDefinition = "TEXT")
    private int jobId;
    List<Object> questions;
}
