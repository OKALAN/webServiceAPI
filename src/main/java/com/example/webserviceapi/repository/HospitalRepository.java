package com.example.webserviceapi.repository;

import com.example.webserviceapi.entities.Hospital;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
