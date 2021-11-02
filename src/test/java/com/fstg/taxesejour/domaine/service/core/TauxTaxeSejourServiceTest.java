package com.fstg.taxesejour.domaine.service.core;

import com.fstg.taxesejour.domaine.process.facade.TauxTaxeSejourService;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import org.junit.jupiter.api.Test;

import java.util.Date;

class TauxTaxeSejourServiceTest {

    private final TauxTaxeSejourService tauxTaxeSejourService;

    TauxTaxeSejourServiceTest(TauxTaxeSejourService tauxTaxeSejourService) {
        this.tauxTaxeSejourService = tauxTaxeSejourService;
    }

    @Test
    void findAll() {
    }

    @Test
    void findByRef() {
    }

    @Test
    void deleteByRef() {
    }

    @Test
    void existsByRef() {
    }

    @Test
    void save() {
        TauxTaxeSejour tauxTaxeSejour = TauxTaxeSejour.builder()
                .taux(5d)
                .dateMaxApplication(new Date())
                .dateMinApplication(new Date())
                .build();
        TauxTaxeSejour resut= tauxTaxeSejourService.save(tauxTaxeSejour);
    }
}