package com.example.webserviceapi.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="fullname")
    private String fullname;

    @Column(name="pwd")
    private String pwd;

    @Column(name="email")
    private String email;

    @Column(name="birth")
    private Date birth;

    @Column(name="nin")
    private String nin;

    @Column(name="adresse")
    private String adresse;

    @Column(name="genre")
    private String genre;


}
