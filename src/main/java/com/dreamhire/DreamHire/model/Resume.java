package com.dreamhire.DreamHire.model;

import com.dreamhire.DreamHire.dto.ProfileDTO;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "TEXT")
    private String profile;
    @Column(columnDefinition = "TEXT")
    private String education;
    @Column(columnDefinition = "TEXT")
    private String professionalExperience;
    @Column(columnDefinition = "TEXT")
    private String projects;
    @Column(columnDefinition = "TEXT")
    private String coursesCertifications;
    @Column(columnDefinition = "TEXT")
    private String skills;
    @Column(columnDefinition = "TEXT")
    private String volunteerExperience;
    @Column(columnDefinition = "TEXT")
    private String otherQualification;
    @Column(columnDefinition = "TEXT")
    private String reference;

    private String email;
    private String name;
    private String profilePicture;
    private String jobTitle;
    private String phone;
    @Column(length = 500)
    private String address;
    @Column(length = 500)
    private String twitter;
    @Column(length = 500)
    private String linkedIn;
    @Column(length = 500)
    private String github;
    @Column(length = 500)
    private String website;
    @Column(length = 500)
    private String discord;
    private String linkedInLabel;



    private String twitterLabel;
    private String githubLabel;
    private String websiteLabel;
    private String discordLabel;

    @OneToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    public Resume(Resume resume) {
        this.id = resume.id;
        this.profile = resume.profile;
        this.education = resume.education;
        this.professionalExperience = resume.professionalExperience;
        this.projects = resume.projects;
        this.coursesCertifications = resume.coursesCertifications;
        this.skills = resume.skills;
        this.volunteerExperience = resume.volunteerExperience;
        this.otherQualification = resume.otherQualification;
        this.reference = resume.reference;
        this.candidate = resume.candidate;
        this.email = resume.email;
        this.name = resume.name;
        this.profilePicture = resume.profilePicture;
        this.jobTitle = resume.jobTitle;
        this.phone = resume.phone;
        this.address = resume.address;
        this.twitter = resume.twitter;
        this.linkedIn = resume.linkedIn;
        this.github = resume.github;
        this.website = resume.website;
        this.discord = resume.discord;
        this.linkedInLabel = resume.linkedInLabel;
        this.twitterLabel = resume.twitterLabel;
        this.githubLabel = resume.githubLabel;
        this.websiteLabel = resume.websiteLabel;
        this.discordLabel = resume.discordLabel;
    }



    public Resume(ProfileDTO profileDTO) {
        this.email = profileDTO.getEmail();
        this.name = profileDTO.getName();
        this.profilePicture = profileDTO.getProfilePicture();
        this.jobTitle = profileDTO.getJobTitle();
        this.phone = profileDTO.getPhone();
        this.address = profileDTO.getAddress();
        this.twitter = profileDTO.getTwitter();
        this.linkedIn = profileDTO.getLinkedIn();
        this.github = profileDTO.getGithub();
        this.website = profileDTO.getWebsite();
        this.discord = profileDTO.getDiscord();
        this.linkedInLabel = profileDTO.getLinkedInLabel();
        this.twitterLabel = profileDTO.getTwitterLabel();
        this.githubLabel = profileDTO.getGithubLabel();
        this.websiteLabel = profileDTO.getWebsiteLabel();
        this.discordLabel = profileDTO.getDiscordLabel();
    }
}
