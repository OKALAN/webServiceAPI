package com.example.webserviceapi.entities;

import lombok.*;
import sun.util.calendar.BaseCalendar;

import javax.persistence.*;
import java.util.Date;


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
    private String birth;

    @Column(name="nin")
    private String nin;

    @Column(name="adresse")
    private String adresse;

    @Column(name="genre")
    private String genre;


}
