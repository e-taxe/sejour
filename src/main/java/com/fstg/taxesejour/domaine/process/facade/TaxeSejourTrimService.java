package com.fstg.taxesejour.domaine.process.facade;

import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourTrim;

import java.util.Date;
import java.util.List;

public interface TaxeSejourTrimService {

    List<TaxeSejourTrimPojo> findAll();

    TaxeSejourTrimPojo findByRefTaxeSejourTrim(String refTaxeSejourTrim);

    int deleteByRefTaxeSejourTrim(String refTaxeSejourTrim);

    TaxeSejourTrimPojo findByAnnee(int annee);
    boolean existeByRef(String ref);
    boolean existsByAnneeAndNumTrim(int annee, int numTrim);

    TaxeSejourTrimPojo findByDateValidation(Date dateValidation);

    int save(TaxeSejourTrim taxeSejourTrim);

}
