package com.dreamhire.DreamHire.model;

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
@Table(name = "interview_candidate")
public class InterviewCandidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String report;
    private String status="accept";
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "int_id")
    private Interview interview;
}
