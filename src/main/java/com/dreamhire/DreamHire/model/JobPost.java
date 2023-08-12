package com.dreamhire.DreamHire.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "jobpost")
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String companyName;
    private Date postedDate;
    private String jobTitle;
    private String jobType;
    private String experience;
    private String education;
    private Date deadline;
    private String description;
    private String howToApply;
    private String jobRequirements;
    private String tags;
    private String author;
    private boolean validate=true;
    private String cover;
    private String currency;
    private String minSalary;
    private String maxSalary;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public JobPost(JobPost post) {

        this.companyName = post.companyName;
        this.postedDate = post.postedDate;
        this.jobTitle = post.jobTitle;
        this.jobType = post.jobType;
        this.experience = post.experience;
        this.education = post.education;
        this.deadline = post.deadline;
        this.description = post.description;
        this.howToApply = post.howToApply;
        this.jobRequirements = post.jobRequirements;
        this.tags = post.tags;
        this.cover = post.cover;
        this.currency = post.currency;
        this.minSalary = post.minSalary;
        this.maxSalary = post.maxSalary;
    }

    public void getAuthor(String email) {
        this.author = email;
    }
}
