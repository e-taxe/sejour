package com.fstg.taxesejour.infrastructure.dao.facade;

import com.fstg.taxesejour.infrastructure.entity.TaxeSejourAnnuele;

public interface TaxeSejourAnnuelDao extends AbstractDao<TaxeSejourAnnuele,Long> {


    TaxeSejourAnnuele findByRef(String ref);

    int deleteByRef(String ref);

    TaxeSejourAnnuele findByAnnee(int annee);

    boolean existsByRef(String ref);




}