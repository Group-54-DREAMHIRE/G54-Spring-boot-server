package com.dreamhire.DreamHire.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class QuestionDTO {
    private String question;
    private String answ1;
    private String answ2;
    private String answ3;
    private String answ4;
    private ArrayList<Integer> answers;
}
