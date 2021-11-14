package com.example.webserviceapi.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hospitals")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="latitude")
    private double latitude;

    @Column(name="longitude")
    private double longitude;

    @Column(name="adresse")
    private String adresse;

    @Column(name="tel")
    private String tel;

    @Column(name="email")
    private String email;

}
