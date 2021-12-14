package com.example.webserviceapi.controller;


import com.example.webserviceapi.entities.Rdv;
import com.example.webserviceapi.service.RdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/rdv")
public class RdvController {

    @Autowired
    private RdvService rdvService;

    @GetMapping
    public ResponseEntity<List<Rdv>> getAllRdv(){
        return  ResponseEntity.ok().body(rdvService.getAllRdv());
    }

    @GetMapping("{id}")
    public ResponseEntity < Rdv > getRdvById(@PathVariable long id) {
        return ResponseEntity.ok().body(rdvService.getRdvById(id));
    }

    @PostMapping
    public ResponseEntity < Rdv > createRdv(@RequestBody Rdv rdv) {
        return ResponseEntity.ok().body(this.rdvService.createRdv(rdv));
    }

    // build update User REST API
    @PutMapping("{id}")
    public ResponseEntity<Rdv> updateRdv(@PathVariable long id,@RequestBody Rdv RdvDetails) {
        Rdv RdvUpdate = rdvService.getRdvById(id);
        // .orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id));

        RdvUpdate.setUser(RdvDetails.getUser());
        RdvUpdate.setHospital(RdvDetails.getHospital());
        RdvUpdate.setDate(RdvDetails.getDate());
        RdvUpdate.setHeure(RdvDetails.getHeure());
        RdvUpdate.setType(RdvDetails.getType());
        rdvService.updateRdv(RdvUpdate);

        return ResponseEntity.ok().body(this.rdvService.updateRdv(RdvDetails));

    }

    // build delete Rdv REST API
    @DeleteMapping("{id}")

    public HttpStatus deleteRdv(@PathVariable long id) {
        this.rdvService.deleteRdv(id);
        return HttpStatus.OK;


    }
}
