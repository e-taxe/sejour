package com.fstg.taxesejour.domaine.process.impl;

import com.fstg.taxesejour.infrastructure.dao.facade.TauxTaxeSejourDao;
import com.fstg.taxesejour.domaine.process.facade.TauxTaxeSejourService;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;

import java.util.List;

public class TauxTaxeSejourServiceImpl implements TauxTaxeSejourService {

    private final TauxTaxeSejourDao tauxTaxeSejourDao;

    public TauxTaxeSejourServiceImpl(TauxTaxeSejourDao tauxTaxeSejourDao) {
        this.tauxTaxeSejourDao = tauxTaxeSejourDao;
    }


    @Override
    public List<TauxTaxeSejour> findAll() {
        return tauxTaxeSejourDao.findAll();
    }

    @Override
    public TauxTaxeSejour findByRef(String ref) {
        return tauxTaxeSejourDao.findByRef(ref);
    }

    @Override
    public int deleteByRef(String ref) {
        tauxTaxeSejourDao.deleteByRef(ref);
        return 1;
    }

    @Override
    public boolean existsByRef(String ref) {
        return tauxTaxeSejourDao.existsByRef(ref);
    }

    @Override
    public TauxTaxeSejour save(TauxTaxeSejour tauxTaxeSejour) {
        return tauxTaxeSejourDao.save(tauxTaxeSejour);
    }
}
