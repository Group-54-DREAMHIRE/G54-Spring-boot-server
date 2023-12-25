package com.dreamhire.DreamHire.model;

import com.dreamhire.DreamHire.dto.CompanyUserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
@Data
public class CompanyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private String role;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public CompanyUser(CompanyUserDTO companyUserDTO) {
        this.name = companyUserDTO.getName();
        this.email = companyUserDTO.getEmail();
        this.password = companyUserDTO.getPassword();
        this.role = companyUserDTO.getRole();
    }
}
