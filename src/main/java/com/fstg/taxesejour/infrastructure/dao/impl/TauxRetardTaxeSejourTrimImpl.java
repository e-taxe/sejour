package com.fstg.taxesejour.infrastructure.dao.impl;

import com.fstg.taxesejour.infrastructure.core.AbstractInfraImpl;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxRetardTaxeSejourTrimInfra;
import com.fstg.taxesejour.infrastructure.dao.repository.SpringDataTauxRetardTaxeSejourTrim;
import com.fstg.taxesejour.infrastructure.entity.TauxRetardTaxeSejourTrim;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TauxRetardTaxeSejourTrimImpl extends AbstractInfraImpl implements TauxRetardTaxeSejourTrimInfra {

    private final SpringDataTauxRetardTaxeSejourTrim springDataTauxRetardTaxeSejourTrim;

    public TauxRetardTaxeSejourTrimImpl(SpringDataTauxRetardTaxeSejourTrim springDataTauxRetardTaxeSejourTrim) {
        this.springDataTauxRetardTaxeSejourTrim = springDataTauxRetardTaxeSejourTrim;
    }

    @Override
    public TauxRetardTaxeSejourTrim save(TauxRetardTaxeSejourTrim entity) {
        return springDataTauxRetardTaxeSejourTrim.save(entity);
    }

    @Override
    public List<TauxRetardTaxeSejourTrim> findAll() {
        return springDataTauxRetardTaxeSejourTrim.findAll();
    }


    @Override
    public TauxRetardTaxeSejourTrim findByRef(String ref) {
        return springDataTauxRetardTaxeSejourTrim.findByRef(ref);
    }

    @Override
    public int deleteByRef(String ref) {
        return springDataTauxRetardTaxeSejourTrim.deleteByRef(ref);
    }

    @Override
    public boolean existsByRef(String ref) {
        return springDataTauxRetardTaxeSejourTrim.existsByRef(ref);
    }

    @Override
    public TauxRetardTaxeSejourTrim getTauxByCurrnetDate(String date) {
        return springDataTauxRetardTaxeSejourTrim.getTauxByCurrnetDate(date);
    }
}
