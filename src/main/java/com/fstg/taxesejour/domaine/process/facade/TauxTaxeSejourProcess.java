package com.fstg.taxesejour.domaine.process.facade;

import com.fstg.taxesejour.domaine.process.impl.Result;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;

import java.util.List;

public interface TauxTaxeSejourProcess {
    Result run(TauxTaxeSejour tauxTaxeSejour);

    List<TauxTaxeSejour> findAll();
}
