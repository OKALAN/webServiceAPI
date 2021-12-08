package com.example.webserviceapi.service;

import com.example.webserviceapi.entities.Rdv;

import java.util.List;

public interface RdvService {

    Rdv createRdv(Rdv Rdv);

    Rdv updateRdv(Rdv Rdv);

    List<Rdv> getAllRdv();

    Rdv getRdvById(long RdvId);

    void deleteRdv(long id);
}
