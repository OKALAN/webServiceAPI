package com.example.webserviceapi.service;

import com.example.webserviceapi.entities.NbrVaxTest;

import java.util.List;

public interface NbrVaxTestService {

    NbrVaxTest createNbrVaxTest(NbrVaxTest nbrVaxTest);

    NbrVaxTest updateNbrVaxTest(NbrVaxTest nbrVaxTest);

    List<NbrVaxTest> getAllNbrVaxTest();

    NbrVaxTest getNbrVaxTestById(long nbrVaxTestId);

    void deleteNbrVaxTest(long id);
}
