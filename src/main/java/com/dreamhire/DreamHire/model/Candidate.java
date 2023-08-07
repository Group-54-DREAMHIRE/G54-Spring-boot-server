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
    private String profilePicture;
    private String description;
    private String phone;
    private String email;
    private String address;
    private String facebook;
    private String twitter;
    private String linkedIn;


//    @Convert(converter = MoneyConvertor.class)
//    private MonetaryAmount minSalary;
//    @Convert(converter = MoneyConvertor.class)
//    private MonetaryAmount maxSalary;




    @ManyToOne
    @JoinColumn(name= "system_user_id")
    private SystemUser systemUser;

    public Candidate(CandidateDataDTO data) {
        this.title = data.getTitle();
        this.birthday = data.getBirthday();
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

    }
}
