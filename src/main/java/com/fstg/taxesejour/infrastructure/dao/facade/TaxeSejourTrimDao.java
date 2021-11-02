package com.fstg.taxesejour.infrastructure.dao.facade;

import com.fstg.taxesejour.infrastructure.entity.TaxeSejourTrim;

import java.util.Date;

public interface TaxeSejourTrimDao extends AbstractDao<TaxeSejourTrim, Long> {


    TaxeSejourTrim findByRef(String ref);

    int deleteByRef(String ref);

    boolean existeByRef(String ref);

    TaxeSejourTrim findByAnnee(int annee);

    boolean existsByAnneeAndNumTrim(int annee, int numTrim);

    TaxeSejourTrim findByDateValidation(Date dateValidation);


}
