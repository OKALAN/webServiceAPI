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
@Table(name = "nbrVaxTest")
public class NbrVaxTest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idn;

    @OneToOne
    @JoinColumn(name = "idh")
    private Hospital hospital;

    @Column(name="date")
    private String date;

    @Column(name="test")
    private long test;

    @Column(name="vax")
    private long vax;


}
