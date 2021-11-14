package com.example.webserviceapi.service;

import com.example.webserviceapi.entities.Hospital;

import java.util.List;

public interface HospitalService {

    List<Hospital> getAllHospital();

    Hospital getHospitalById(long hospitalId);
}
