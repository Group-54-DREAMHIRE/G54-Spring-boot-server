package com.dreamhire.DreamHire.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "candidates")
public class Candidate extends SystemUser{
    @Enumerated(value = EnumType.STRING)
    private Languages languages;
    private Date birthdate;
}
