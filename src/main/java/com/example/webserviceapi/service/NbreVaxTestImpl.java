package com.example.webserviceapi.service;

import com.example.webserviceapi.entities.NbrVaxTest;
import com.example.webserviceapi.exception.ResourceNotFoundException;
import com.example.webserviceapi.repository.NbrVaxTestRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@SpringBootApplication
public class NbreVaxTestImpl implements NbrVaxTestService {



    private final NbrVaxTestRepository NbrVaxTestRepository;



    public NbreVaxTestImpl(com.example.webserviceapi.repository.NbrVaxTestRepository nbrVaxTestRepository) {
        NbrVaxTestRepository = nbrVaxTestRepository;
    }


    @Override
    public NbrVaxTest createNbrVaxTest(NbrVaxTest NbrVaxTest) {
        return NbrVaxTestRepository.save(NbrVaxTest);
    }

    @Override
    public NbrVaxTest updateNbrVaxTest(NbrVaxTest NbrVaxTest) {
        Optional<com.example.webserviceapi.entities.NbrVaxTest> NbrVaxTestDB = this.NbrVaxTestRepository.findById(NbrVaxTest.getIdn());

        if (NbrVaxTestDB.isPresent()) {

            com.example.webserviceapi.entities.NbrVaxTest NbrVaxTestUpdate = NbrVaxTestDB.get();
            NbrVaxTestUpdate.setIdn(NbrVaxTest.getIdn());
            NbrVaxTestUpdate.setHospital(NbrVaxTest.getHospital());
            NbrVaxTestUpdate.setDate(NbrVaxTest.getDate());
            NbrVaxTestUpdate.setTest(NbrVaxTest.getTest());
            NbrVaxTestUpdate.setVax(NbrVaxTest.getVax());
            NbrVaxTestRepository.save(NbrVaxTestUpdate);
            return NbrVaxTestUpdate;

        }
        else {

            throw new ResourceNotFoundException("Record not found with id : " + NbrVaxTest.getIdn());
        }

    }

    @Override
    public List<NbrVaxTest> getAllNbrVaxTest() {
        return this.NbrVaxTestRepository.findAll();
    }

    @Override
    public NbrVaxTest getNbrVaxTestById(long NbrVaxTestId) {
        Optional<NbrVaxTest> NbrVaxTestDb = this.NbrVaxTestRepository.findById(NbrVaxTestId);

        if (NbrVaxTestDb.isPresent()) {
            return NbrVaxTestDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + NbrVaxTestId);
        }
    }

    @Override
    public void deleteNbrVaxTest(long id) {

        Optional <NbrVaxTest> NbrVaxTestDb = this.NbrVaxTestRepository.findById(id);

        if (NbrVaxTestDb.isPresent()) {
            this.NbrVaxTestRepository.delete(NbrVaxTestDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }

    }
}
