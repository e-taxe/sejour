package com.fstg.taxesejour.infrastructure.dao.impl;

import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourTrimDao;
import com.fstg.taxesejour.infrastructure.dao.repository.SpringDataTaxeSejourTrimDao;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourTrim;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class SpringTaxeSejourTrimService implements TaxeSejourTrimDao {
    private final SpringDataTaxeSejourTrimDao springDataTaxeSejourTrimDao;


    public SpringTaxeSejourTrimService(SpringDataTaxeSejourTrimDao springDataTaxeSejourTrimDao) {
        this.springDataTaxeSejourTrimDao = springDataTaxeSejourTrimDao;
    }

    @Override
    public List<TaxeSejourTrim> findAll() {
        return springDataTaxeSejourTrimDao.findAll();
    }



    @Override
    public TaxeSejourTrim findByRef(String ref) {
        return springDataTaxeSejourTrimDao.findByRef(ref);
    }

    @Override
    public int deleteByRef(String ref) {
        return springDataTaxeSejourTrimDao.deleteByRef(ref);
    }

    @Override
    public boolean existeByRef(String ref) {
        return springDataTaxeSejourTrimDao.existsByRef(ref);
    }

    @Override
    public TaxeSejourTrim findByAnnee(int annee) {
        return springDataTaxeSejourTrimDao.findByAnnee(annee);
    }

    @Override
    public boolean existsByAnneeAndNumTrim(int annee, int numTrim) {
        return springDataTaxeSejourTrimDao.existsByAnneeAndNumTrim(annee, numTrim);
    }

    @Override
    public TaxeSejourTrim findByDateValidation(Date dateValidation) {
        return springDataTaxeSejourTrimDao.findByDateValidation(dateValidation);
    }

    @Override
    public TaxeSejourTrim save(TaxeSejourTrim taxeSejourTrim) {
        return springDataTaxeSejourTrimDao.save(taxeSejourTrim);
    }
}
