package com.fstg.taxesejour.infrastructure.dao.impl;

import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourAnnuelDao;
import com.fstg.taxesejour.infrastructure.dao.repository.SpringDataTaxeSejourAnnuelDao;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourAnnuele;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SpringTaxeSejourAnnuelService implements TaxeSejourAnnuelDao {
    private final SpringDataTaxeSejourAnnuelDao springDtataxeSejourAnnuelDao;


    public SpringTaxeSejourAnnuelService(SpringDataTaxeSejourAnnuelDao springDtataxeSejourAnnuelDao) {
        this.springDtataxeSejourAnnuelDao = springDtataxeSejourAnnuelDao;
    }

    @Override
    public List<TaxeSejourAnnuele> findAll() {
        return springDtataxeSejourAnnuelDao.findAll();
    }



    @Override
    public TaxeSejourAnnuele findByRef(String ref) {
        return springDtataxeSejourAnnuelDao.findByRef(ref);
    }

    @Override
    public int deleteByRef(String ref) {
        return springDtataxeSejourAnnuelDao.deleteByRef(ref);
    }

    @Override
    public TaxeSejourAnnuele findByAnnee(int annee) {
        return springDtataxeSejourAnnuelDao.findByAnnee(annee);
    }

    @Override
    public boolean existsByRef(String ref) {
        return springDtataxeSejourAnnuelDao.existsByRef(ref);
    }


    @Override
    public TaxeSejourAnnuele save(TaxeSejourAnnuele taxeSejourAnnuele) {
        return springDtataxeSejourAnnuelDao.save(taxeSejourAnnuele);
    }
}
