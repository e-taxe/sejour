package com.fstg.taxesejour.infrastructure.dao.impl;

import com.fstg.taxesejour.infrastructure.dao.facade.TauxTaxeSejourDao;
import com.fstg.taxesejour.infrastructure.dao.repository.SpringTauxTaxeSejourDao;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SpringTauxTaxeSejourService implements TauxTaxeSejourDao {
    private final SpringTauxTaxeSejourDao springTauxTaxeSejourDao;

    public SpringTauxTaxeSejourService(SpringTauxTaxeSejourDao springTauxTaxeSejourDao) {
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
}
