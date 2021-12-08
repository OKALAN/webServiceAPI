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
@Table(name = "rdv")
public class Rdv {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idr;

    @OneToOne
    @JoinColumn(name = "idu")
    private User user;

    @OneToOne
    @JoinColumn(name = "idh")
    private Hospital hospital;

    @Column(name="date")
    private String date;

    @Column(name="type")
    private String type;

    @Column(name="heure")
    private String heure;


}
