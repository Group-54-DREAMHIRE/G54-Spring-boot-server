package com.dreamhire.DreamHire.util;

import com.dreamhire.DreamHire.dto.SendMailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/")
public class SendMailUtil {

    @Autowired
    private JavaMailSender javaMailSender;
    @PostMapping("send")
    public String sendMail(@RequestBody SendMailDTO sendMailDTO){

        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(sendMailDTO.getSubject());
            message.setFrom("dreamhireofficial@gmail.com");
            message.setTo(sendMailDTO.getEmail());
            message.setText(sendMailDTO.getText());
            javaMailSender.send(message);
            return "Success";
        }catch (Exception e){
            return e.getMessage();
        }

    }
}
