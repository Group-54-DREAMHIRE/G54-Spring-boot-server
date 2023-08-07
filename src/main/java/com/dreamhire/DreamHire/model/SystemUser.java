package com.dreamhire.DreamHire.model;
import lombok.*;


import javax.persistence.*;
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "systemusers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public  class SystemUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private UserType userType;

}
