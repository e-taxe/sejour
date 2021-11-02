package com.fstg.taxesejour.domaine.process.facade;


import com.fstg.taxesejour.infrastructure.entity.TaxeSejourAnnuele;

import java.util.List;

public interface TaxeSejourAnnuelService {
    List<TaxeSejourAnnuele> findAll();

    TaxeSejourAnnuele findByRef(String ref);

    boolean existsByRef(String ref);

    int deleteByRef(String ref);

    TaxeSejourAnnuele findByAnnee(int annee);


    int save(TaxeSejourAnnuele TaxeSejourAnnuel);

}
