package com.dreamhire.DreamHire.dto;

import lombok.Data;

@Data
public class SendMailDTO {
    private String email;
    private  String subject;
    private String text;
}
