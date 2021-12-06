package com.fstg.taxesejour.infrastructure.dao.impl;


import com.fstg.taxesejour.domaine.pojo.TauxTaxeSejourPojo;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxTaxeSejourInfra;
import com.fstg.taxesejour.infrastructure.dao.repository.TauxTaxeSejourRepository;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class TauxTaxeSejourInfraImpl implements TauxTaxeSejourInfra {
    private final TauxTaxeSejourRepository springTauxTaxeSejourDao;
    private final ModelMapper modelMapper;

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

    @Override
    public TauxTaxeSejourPojo getCurrentTauxTaxe(String date) {
        return modelMapper.map(springTauxTaxeSejourDao.getTauxByCurrnetDate(date), TauxTaxeSejourPojo.class);
    }

//    @Override
//    public TauxTaxeSejour getCurrentTauxTaxe(String date) {
//        return springTauxTaxeSejourDao.getCurrentTauxTaxe(date);
//    }
}
