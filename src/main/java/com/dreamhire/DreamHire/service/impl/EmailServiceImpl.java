package com.dreamhire.DreamHire.service.impl;

import com.dreamhire.DreamHire.dto.SendMailStatusDTO;
import com.dreamhire.DreamHire.service.EmailService;
import com.dreamhire.DreamHire.util.StatusMsgList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendApplyMail(SendMailStatusDTO sendMailStatusDTO) {
        String message = StatusMsgList.applyMessage(sendMailStatusDTO);
        boolean response = sendMail(message, sendMailStatusDTO);
        if(response){
            return "success";
        }else {
            return "error";
        }
    }

    @Override
    public String sendShortlistMail(SendMailStatusDTO sendMailStatusDTO) {
        String message = StatusMsgList.shortlistMessage(sendMailStatusDTO);
        boolean response = sendMail(message, sendMailStatusDTO);
        if(response){
            return "success";
        }else {
            return "error";
        }
    }

    @Override
    public String rejectMail(SendMailStatusDTO sendMailStatusDTO) {
        String message = StatusMsgList.rejectMessage(sendMailStatusDTO);
        boolean response = sendMail(message, sendMailStatusDTO);
        if(response){
            return "success";
        }else {
            return "error";
        }
    }

    public boolean sendMail(String message, SendMailStatusDTO sendMailStatusDTO){
        try{
            String subject = sendMailStatusDTO.getJobTitle();
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setSubject(subject);
            mail.setFrom("dreamhireofficial@gmail.com");
            mail.setTo(sendMailStatusDTO.getEmail());
            mail.setText(message);
            javaMailSender.send(mail);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
