package com.fstg.taxesejour.infrastructure.dao.impl;

import com.fstg.taxesejour.infrastructure.core.AbstractInfraImpl;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxTaxeSejourInfra;
import com.fstg.taxesejour.infrastructure.dao.repository.SpringDataTauxTaxeSejourDao;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SpringTauxTaxeSejourService extends AbstractInfraImpl implements TauxTaxeSejourInfra {
    private final SpringDataTauxTaxeSejourDao springTauxTaxeSejourDao;

    public SpringTauxTaxeSejourService(SpringDataTauxTaxeSejourDao springTauxTaxeSejourDao) {
        this.springTauxTaxeSejourDao = springTauxTaxeSejourDao;
    }

    @Override
    public TauxTaxeSejour save(TauxTaxeSejour entity) {
        return springTauxTaxeSejourDao.save(entity);
    }

    @Override
    public List<TauxTaxeSejour> findAll() {
        return springTauxTaxeSejourDao.findAll();
    }

    @Override
    public TauxTaxeSejour findByRef(String ref) {
        return springTauxTaxeSejourDao.findByRef(ref);
    }

    @Override
    public int deleteByRef(String ref) {
        return springTauxTaxeSejourDao.deleteByRef(ref);
    }

    @Override
    public boolean existsByRef(String ref) {
        return springTauxTaxeSejourDao.existsByRef(ref);
    }

//    @Override
//    public TauxTaxeSejour getCurrentTauxTaxe(String date) {
//        return springTauxTaxeSejourDao.getCurrentTauxTaxe(date);
//    }
}
