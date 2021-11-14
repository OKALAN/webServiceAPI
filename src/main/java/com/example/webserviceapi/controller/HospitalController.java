package com.example.webserviceapi.controller;

import com.example.webserviceapi.entities.Hospital;
import com.example.webserviceapi.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/hospitals")
public class HospitalController {

    @Autowired
    private  HospitalService hospitalService;


    @GetMapping
    public ResponseEntity<List<Hospital>> getAllHospital(){
        return  ResponseEntity.ok().body(hospitalService.getAllHospital());
    }

    @GetMapping("{id}")
    public ResponseEntity < Hospital > getHospitalById(@PathVariable long id) {
        return ResponseEntity.ok().body(hospitalService.getHospitalById(id));
    }


    
}
