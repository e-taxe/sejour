package com.fstg.taxesejour.infrastructure.dao;

import com.fstg.taxesejour.infrastructure.entity.TaxeSejourTrim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TaxeSejourTrimDao extends JpaRepository<TaxeSejourTrim, Long> {
    //    converter from POJO TO ENTITY and inverse
    TaxeSejourTrim findByRefTaxeSejourTrim(String refTaxeSejourTrim);

    int deleteByRefTaxeSejourTrim(String refTaxeSejourTrim);

    TaxeSejourTrim findByAnnee(int annee);

    TaxeSejourTrim findByDateValidation(Date dateValidation);


}
