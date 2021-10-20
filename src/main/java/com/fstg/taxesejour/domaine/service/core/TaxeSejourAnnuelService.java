package com.fstg.taxesejour.domaine.service.core;

import com.fstg.taxesejour.domaine.pojo.TaxeSejourAnnuelePojo;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourAnnuele;

import java.util.List;

public interface TaxeSejourAnnuelService {

    TaxeSejourAnnuelePojo save(TaxeSejourAnnuele taxeSejourAnnuele);

    List<TaxeSejourAnnuelePojo> findAll();

    TaxeSejourAnnuelePojo findByRef(String ref);


    TaxeSejourAnnuelePojo findByAnnee(int annee);

}
