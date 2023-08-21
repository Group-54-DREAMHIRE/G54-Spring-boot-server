package com.dreamhire.DreamHire.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    @Column(length = 500)
    private String title;
    @Column(length = 4000)
    private String description;
    @Column(length = 500)
    private String cover;
    @Column(length = 4000)
    private String tags;
    private Date date;
    private Date postedDate;
    private LocalTime startTime;
    private LocalTime endTime;
    @Column(length = 500)
    private String companies;
    private String email;
    private String phone;
    private boolean validate= true;


}
