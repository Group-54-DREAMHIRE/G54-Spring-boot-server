package com.dreamhire.DreamHire.service;

import com.dreamhire.DreamHire.dto.SendMailStatusDTO;

public interface EmailService {

    String sendApplyMail(SendMailStatusDTO sendMailStatusDTO);

    String sendShortlistMail(SendMailStatusDTO sendMailStatusDTO);

    String rejectMail(SendMailStatusDTO sendMailStatusDTO);
}
