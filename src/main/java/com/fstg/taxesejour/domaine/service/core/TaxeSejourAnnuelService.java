package com.fstg.taxesejour.domaine.service.core;


import com.fstg.taxesejour.infrastructure.entity.TaxeSejourAnnuele;

import java.util.List;

public interface TaxeSejourAnnuelService {
    List<TaxeSejourAnnuele> findAll();

    TaxeSejourAnnuele findByRef(String ref);

    int deleteByRef(String ref);

    TaxeSejourAnnuele findByAnnee(int annee);


    TaxeSejourAnnuele save(TaxeSejourAnnuele TaxeSejourAnnuel);

}
