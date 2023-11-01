package com.dreamhire.DreamHire.model;

import com.dreamhire.DreamHire.dto.QuestionDTO;
import com.dreamhire.DreamHire.dto.TestDTO;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectionTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String instructions;
    private String type;
    private Date date;
    private int duration;
    private int passMark;
    private int numOfQuestions;
    @Column(columnDefinition = "TEXT")
    private String questions;

    @ManyToOne
    @JoinColumn(name = "com_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobPost jobPost;


    public SelectionTest(TestDTO testDTO) {
        this.title = testDTO.getTitle();
        this.instructions = testDTO.getInstructions();
        this.type = testDTO.getType();
        this.date = testDTO.getDate();
        this.duration = testDTO.getDuration();
        this.passMark = testDTO.getPassMark();
        this.numOfQuestions = testDTO.getNumOfQuestions();
    }
}
