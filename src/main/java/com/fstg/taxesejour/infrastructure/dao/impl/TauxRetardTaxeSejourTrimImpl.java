package com.fstg.taxesejour.infrastructure.dao.impl;

import com.fstg.taxesejour.infrastructure.dao.facade.TauxRetardTaxeSejourTrimInfra;
import com.fstg.taxesejour.infrastructure.dao.repository.TauxRetardTaxeSejourTrimRepository;
import com.fstg.taxesejour.infrastructure.entity.TauxRetardTaxeSejourTrim;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TauxRetardTaxeSejourTrimImpl implements TauxRetardTaxeSejourTrimInfra {

    private final TauxRetardTaxeSejourTrimRepository tauxRetardTaxeSejourTrimRepository;

    public TauxRetardTaxeSejourTrimImpl(TauxRetardTaxeSejourTrimRepository tauxRetardTaxeSejourTrimRepository) {
        this.tauxRetardTaxeSejourTrimRepository = tauxRetardTaxeSejourTrimRepository;
    }

    @Override
    public TauxRetardTaxeSejourTrim save(TauxRetardTaxeSejourTrim entity) {
        return tauxRetardTaxeSejourTrimRepository.save(entity);
    }

    @Override
    public List<TauxRetardTaxeSejourTrim> findAll() {
        return tauxRetardTaxeSejourTrimRepository.findAll();
    }


    @Override
    public TauxRetardTaxeSejourTrim findByRef(String ref) {
        return tauxRetardTaxeSejourTrimRepository.findByRef(ref);
    }

    @Override
    public int deleteByRef(String ref) {
        return tauxRetardTaxeSejourTrimRepository.deleteByRef(ref);
    }

    @Override
    public boolean existsByRef(String ref) {
        return tauxRetardTaxeSejourTrimRepository.existsByRef(ref);
    }

    @Override
    public TauxRetardTaxeSejourTrim getTauxByCurrnetDate(String date) {
        return tauxRetardTaxeSejourTrimRepository.getTauxByCurrnetDate(date);
    }
}
