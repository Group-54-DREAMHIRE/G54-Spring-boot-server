package com.dreamhire.DreamHire.model;

import com.dreamhire.DreamHire.dto.InterviewDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "interviews")
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private Date startTime;
    private int duration;
    private String withInt;
    private boolean free=true;
    private String meetingLink;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobPost jobPost;

    public Interview(InterviewDTO interviewDTO) {
        this.type = interviewDTO.getType();
        this.duration = interviewDTO.getDuration();
        this.withInt = interviewDTO.getWithInt();
        this.startTime = interviewDTO.getStartTime();
        this.meetingLink = interviewDTO.getMeetingLink();
    }
}
