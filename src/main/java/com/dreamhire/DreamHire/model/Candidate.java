package com.dreamhire.DreamHire.model;
import com.dreamhire.DreamHire.dto.CandidateDataDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "candidates")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private Date birthday;
    private String city;
    private String name;
    private boolean visible = true;
    private String profilePicture;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String phone;
    private String email;
    @Column(length = 500)
    private String address;
    @Column(length = 500)
    private String facebook;
    @Column(length = 500)
    private String twitter;
    @Column(length = 500)
    private String linkedIn;
    private String currency;
    private String minSalary;
    private String maxSalary;





    @ManyToOne
    @JoinColumn(name= "system_user_id")
    private SystemUser systemUser;

    public Candidate(CandidateDataDTO data) {
        this.title = data.getTitle();
        this.birthday = data.getBirthday();
        this.currency = data.getCurrency();
        this.minSalary = data.getMinSalary();
        this.maxSalary = data.getMaxSalary();
        this.city = data.getCity();
        this.name = data.getName();
        this.profilePicture = data.getProfilePicture();
        this.description = data.getDescription();
        this.phone = data.getPhone();
        this.email = data.getEmail();
        this.address = data.getAddress();
        this.facebook = data.getFacebook();
        this.twitter = data.getTwitter();
        this.linkedIn = data.getLinkedIn();
        this.visible = data.isVisible();
    }
}
