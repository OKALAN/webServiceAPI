package com.example.webserviceapi.controller;

import com.example.webserviceapi.entities.NbrVaxTest;
import com.example.webserviceapi.service.NbrVaxTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/ntv")
public class NbrVaxTestController {


    @Autowired
    private NbrVaxTestService NbrVaxTestService;

    @GetMapping
    public ResponseEntity<List<NbrVaxTest>> getAllNbrVaxTest(){
        return  ResponseEntity.ok().body(NbrVaxTestService.getAllNbrVaxTest());
    }

    @GetMapping("{id}")
    public ResponseEntity < NbrVaxTest > getNbrVaxTestById(@PathVariable long id) {
        return ResponseEntity.ok().body(NbrVaxTestService.getNbrVaxTestById(id));
    }

    @PostMapping
    public ResponseEntity < NbrVaxTest > createNbrVaxTest(@RequestBody NbrVaxTest NbrVaxTest) {
        return ResponseEntity.ok().body(this.NbrVaxTestService.createNbrVaxTest(NbrVaxTest));
    }

    // build update User REST API
    @PutMapping("{id}")
    public ResponseEntity<NbrVaxTest> updateNbrVaxTest(@PathVariable long id,@RequestBody NbrVaxTest NbrVaxTestDetails) {
        NbrVaxTest NbrVaxTestUpdate = NbrVaxTestService.getNbrVaxTestById(id);



        NbrVaxTestUpdate.setHospital(NbrVaxTestDetails.getHospital());
        NbrVaxTestUpdate.setDate(NbrVaxTestDetails.getDate());
        NbrVaxTestUpdate.setTest(NbrVaxTestDetails.getTest());
        NbrVaxTestUpdate.setVax(NbrVaxTestDetails.getVax());
        NbrVaxTestService.updateNbrVaxTest(NbrVaxTestUpdate);

        return ResponseEntity.ok().body(this.NbrVaxTestService.updateNbrVaxTest(NbrVaxTestDetails));

    }

    // build delete NbrVaxTest REST API
    @DeleteMapping("{id}")

    public HttpStatus deleteNbrVaxTest(@PathVariable long id) {
        this.NbrVaxTestService.deleteNbrVaxTest(id);
        return HttpStatus.OK;


    }
}
