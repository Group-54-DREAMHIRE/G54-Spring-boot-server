package com.dreamhire.DreamHire.dto;
import com.dreamhire.DreamHire.model.SystemUser;
import lombok.Data;

@Data
public class AuthResponseDTO {
    private String accessToken;
    private String tokenType = "Bearer ";
    private SystemUser user;


    public AuthResponseDTO(String accessToken, SystemUser user) {
        this.accessToken = accessToken;
        this.user = user;
    }


}
