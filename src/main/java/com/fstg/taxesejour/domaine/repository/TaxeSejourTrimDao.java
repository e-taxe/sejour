package com.fstg.taxesejour.domaine.repository;

import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourTrim;

import java.util.Date;
import java.util.List;

public interface TaxeSejourTrimDao {

    List<TaxeSejourTrim> findAll();
    TaxeSejourTrim findByRef(String ref);

    int deleteByRef(String ref);

    TaxeSejourTrim findByAnnee(int annee);

    TaxeSejourTrim findByDateValidation(Date dateValidation);
    TaxeSejourTrim save(TaxeSejourTrim taxeSejourTrim);


}
