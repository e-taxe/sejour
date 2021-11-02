package com.fstg.taxesejour.domaine.process.facade;

import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;

import java.util.List;

public interface TauxTaxeSejourService {
    List<TauxTaxeSejour> findAll();

    TauxTaxeSejour findByRef(String ref);

    int deleteByRef(String ref);

    boolean existsByRef(String ref);

    TauxTaxeSejour save(TauxTaxeSejour tauxTaxeSejour);
}
