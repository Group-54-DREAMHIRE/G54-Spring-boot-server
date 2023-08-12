package com.dreamhire.DreamHire.dto;

import com.dreamhire.DreamHire.model.Company;
import com.dreamhire.DreamHire.model.UserType;
import lombok.Data;

@Data
public class SendCompanyDTO {
    private Company user;
    private String accessToken;
    private String userType;

    public SendCompanyDTO(Company user, String token ,String userType) {
        this.user = user;
        this.accessToken = token;
        this.userType = userType;
    }

}
