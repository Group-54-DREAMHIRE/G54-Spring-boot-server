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
    private String description;
    private String about;
    private String services;
    private String serviceKeys;
    private boolean visible = true;
    private boolean approval = false;
    private boolean payment = false;
    private String phone;
    private String email;
    private String address;
    private String facebook;
    private String twitter;
    private String linkedIn;

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
