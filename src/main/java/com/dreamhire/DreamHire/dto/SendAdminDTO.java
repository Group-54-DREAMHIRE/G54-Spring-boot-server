package com.dreamhire.DreamHire.dto;

import com.dreamhire.DreamHire.model.Admin;
import lombok.Data;

@Data
public class SendAdminDTO {
    private Admin user;
    private String accessToken;

    public SendAdminDTO(Admin user, String token, String userType) {
        this.user = user;
        this.accessToken = token;
    }
}
