package com.dreamhire.DreamHire.model;

import com.dreamhire.DreamHire.dto.CompanyDataDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String logo;
    @Column(columnDefinition = "TEXT")
    private String images;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(length = 4000)
    private String about;
    @Column(length = 4000)
    private String services;
    @Column(length = 4000)
    private String serviceKeys;
    private boolean visible = true;
    private boolean approval = false;
    private boolean payment = false;
    private boolean reject = false;
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
    @Column(length = 500)
    private String registration;

    @ManyToOne
    @JoinColumn(name = "system_user_id")
    private SystemUser systemUser;



    public Company(CompanyDataDTO companyData) {
        this.name = companyData.getName();
        this.description = companyData.getDescription();
        this.about = companyData.getAbout();
        this.services = companyData.getServices();
        this.serviceKeys = companyData.getServiceKeys();
        this.visible = companyData.isVisible();
        this.phone = companyData.getPhone();
        this.email = companyData.getEmail();
        this.address = companyData.getAddress();
        this.facebook = companyData.getFacebook();
        this.twitter = companyData.getTwitter();
        this.linkedIn = companyData.getLinkedIn();
    }
}
