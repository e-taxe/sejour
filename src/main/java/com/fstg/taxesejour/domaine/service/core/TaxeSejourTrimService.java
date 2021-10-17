package com.fstg.taxesejour.domaine.service.core;

import com.fstg.taxesejour.application.dto.TaxeSejourTrimDtoRequest;
import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;

import java.util.Date;
import java.util.List;

public interface TaxeSejourTrimService {

    List<TaxeSejourTrimPojo> findAll();

    TaxeSejourTrimPojo findByRefTaxeSejourTrim(String refTaxeSejourTrim);

    int deleteByRefTaxeSejourTrim(String refTaxeSejourTrim);

    TaxeSejourTrimPojo findByAnnee(int annee);

    TaxeSejourTrimPojo findByDateValidation(Date dateValidation);

    TaxeSejourTrimPojo save(TaxeSejourTrimDtoRequest taxeSejourTrimDtoRequest);
}
