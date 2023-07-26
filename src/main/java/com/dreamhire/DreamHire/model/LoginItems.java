package com.dreamhire.DreamHire.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="login_items")
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private UserType userType;
    private String navBarData;
    private String sideBarData;
}
