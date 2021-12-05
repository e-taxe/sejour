package com.fstg.taxesejour.infrastructure.dao.impl;

import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourAnnuelInfra;
import com.fstg.taxesejour.infrastructure.dao.repository.TaxeSejourAnnuelRepository;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourAnnuele;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaxeSejourAnnuelInfraImpl implements TaxeSejourAnnuelInfra {
    private final TaxeSejourAnnuelRepository springDtataxeSejourAnnuelDao;


    public TaxeSejourAnnuelInfraImpl(TaxeSejourAnnuelRepository springDtataxeSejourAnnuelDao) {
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
