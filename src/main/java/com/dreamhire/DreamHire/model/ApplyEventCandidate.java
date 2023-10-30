package com.dreamhire.DreamHire.model;

import com.dreamhire.DreamHire.dto.ApplyEventDTO;
import com.dreamhire.DreamHire.dto.ApplyJobDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "apply_event_Candidate")
public class ApplyEventCandidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    @Enumerated(value = EnumType.STRING)
    private CandidateType candidateType=CandidateType.pending;
    private String candidateName;
    private String candidatePhone;
    private String candidateEmail;
    private String candidateAddress;

    public ApplyEventCandidate(ApplyEventDTO applyEvent) {
        this.candidateName = applyEvent.getCandidateName();
        this.candidatePhone = applyEvent.getCandidatePhone();
        this.candidateEmail = applyEvent.getCandidateEmail();
        this.candidateAddress = applyEvent.getCandidateAddress();
    }

}
