package com.dreamhire.DreamHire.model;

import com.dreamhire.DreamHire.dto.ApplyJobDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "apply_job_Candidate")
public class ApplyJobCandidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobPost jobPost;

    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    @Enumerated(value = EnumType.STRING)
    private CandidateType candidateType=CandidateType.pending;
    private String candidateName;
    private String candidatePhone;
    private String candidateEmail;
    private String candidateCity;
    private String currency="$USD";
    private String expectSalary="500";
    private String jobTitle;
    @Column(length = 500)
    private String tags;

    public ApplyJobCandidate(ApplyJobDTO applyJob) {
        this.candidateName = applyJob.getCandidateName();
        this.candidatePhone = applyJob.getCandidatePhone();
        this.candidateEmail = applyJob.getCandidateEmail();
        this.candidateCity = applyJob.getCandidateCity();
        this.jobTitle = applyJob.getJobTitle();
        this.tags = applyJob.getTags();
    }
}
