package com.example.webserviceapi.service;


import com.example.webserviceapi.entities.Rdv;
import com.example.webserviceapi.exception.ResourceNotFoundException;
import com.example.webserviceapi.repository.RdvRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@SpringBootApplication
public class RdvServiceImpl implements RdvService {

    private final RdvRepository rdvRepository;

    public RdvServiceImpl(RdvRepository rdvRepository) {
        this.rdvRepository = rdvRepository;
    }


    @Override
    public Rdv createRdv(Rdv Rdv) {
        return rdvRepository.save(Rdv);
    }

    @Override
    public Rdv updateRdv(Rdv Rdv) {
        Optional < Rdv > RdvDB = this.rdvRepository.findById(Rdv.getIdr());

        if (RdvDB.isPresent()) {

            Rdv RdvUpdate = RdvDB.get();
            RdvUpdate.setIdr(Rdv.getIdr());
            RdvUpdate.setUser(Rdv.getUser());
            RdvUpdate.setHospital(Rdv.getHospital());
            RdvUpdate.setDate(Rdv.getDate());
            RdvUpdate.setHeure(Rdv.getHeure());
            RdvUpdate.setType(Rdv.getType());
            rdvRepository.save(RdvUpdate);
            return RdvUpdate;

        }
        else {

            throw new ResourceNotFoundException("Record not found with id : " + Rdv.getIdr());
        }

    }

    @Override
    public List<Rdv> getAllRdv() {
        return this.rdvRepository.findAll();
    }

    @Override
    public Rdv getRdvById(long RdvId) {
        Optional<Rdv> RdvDb = this.rdvRepository.findById(RdvId);

        if (RdvDb.isPresent()) {
            return RdvDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + RdvId);
        }
    }

    @Override
    public void deleteRdv(long id) {

        Optional < Rdv > RdvDb = this.rdvRepository.findById(id);

        if (RdvDb.isPresent()) {
            this.rdvRepository.delete(RdvDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }

    }
}
