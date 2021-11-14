package com.example.webserviceapi.service;

import com.example.webserviceapi.entities.Hospital;
import com.example.webserviceapi.exception.ResourceNotFoundException;
import com.example.webserviceapi.repository.HospitalRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalServiceImpl(com.example.webserviceapi.repository.HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return this.hospitalRepository.findAll();
    }

    @Override
    public Hospital getHospitalById(long hospitalId) {
        Optional<Hospital> HospitalDb = this.hospitalRepository.findById(hospitalId);

        if (HospitalDb.isPresent()) {
            return HospitalDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " +HospitalDb);
        }
    }
}
