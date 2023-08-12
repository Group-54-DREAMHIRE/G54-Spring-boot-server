package com.dreamhire.DreamHire.dto;

import com.dreamhire.DreamHire.model.Candidate;
import lombok.Data;

@Data
public class SendCandidateDTO {
    private Candidate user;
    private String accessToken;
    private String userType;

    public SendCandidateDTO(Candidate user, String token, String userType) {
        this.user  = user;
        this.accessToken = token;
        this.userType = userType;
    }
}
