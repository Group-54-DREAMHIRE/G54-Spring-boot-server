package com.dreamhire.DreamHire.model;

import com.dreamhire.DreamHire.dto.EventDTO;
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
    private String companyName;
    private String author;
    @Column(length = 500)
    private String title;
    @Column(length = 4000)
    private String description;
    @Column(length = 500)
    private String cover;
    @Column(length = 4000)
    private String companies;
    private Date date;
    private Date postedDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String email;
    private String phone;
    private boolean validate= true;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Event(EventDTO eventDTO) {
        this.companyName = eventDTO.getCompanyName();
        this.title = eventDTO.getTitle();
        this.description = eventDTO.getDescription();
        this.cover = eventDTO.getCover();
        this.date = eventDTO.getDate();
        this.postedDate = eventDTO.getPostedDate();
        this.startTime = eventDTO.getStartTime();
        this.endTime = eventDTO.getEndTime();
        this.companies = eventDTO.getCompanies();
        this.email = eventDTO.getEmail();
        this.phone = eventDTO.getPhone();
    }
    public void setAuthor(String email){ this.author = email; }
}
