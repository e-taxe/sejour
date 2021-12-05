package com.fstg.taxesejour.infrastructure.dao.impl;

import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.infrastructure.converter.TaxeSejourTrimConverter;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourTrimInfra;
import com.fstg.taxesejour.infrastructure.dao.repository.TaxeSejourTrimRepository;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourTrim;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class TaxeSejourTrimInfraImpl implements TaxeSejourTrimInfra {
    private final TaxeSejourTrimRepository taxeSejourTrimRepository;
    private final TaxeSejourTrimConverter taxeSejourTrimConverter;


    public TaxeSejourTrimInfraImpl(TaxeSejourTrimRepository taxeSejourTrimRepository, TaxeSejourTrimConverter taxeSejourTrimConverter) {
        this.taxeSejourTrimRepository = taxeSejourTrimRepository;
        this.taxeSejourTrimConverter = taxeSejourTrimConverter;
    }

    @Override
    public List<TaxeSejourTrimPojo> findAll() {
        return taxeSejourTrimRepository.findAll().stream().map(taxeSejourTrimConverter::toPojo).collect(Collectors.toList());
    }


    @Override
    public TaxeSejourTrimPojo findByRef(String ref) {
        TaxeSejourTrim sejourTrim = taxeSejourTrimRepository.findByRef(ref);
        return taxeSejourTrimConverter.toPojo(sejourTrim);
    }

    @Override
    public int deleteByRef(String ref) {
        return taxeSejourTrimRepository.deleteByRef(ref);
    }

    @Override
    public boolean existeByRef(String ref) {
        return taxeSejourTrimRepository.existsByRef(ref);
    }

    @Override
    public TaxeSejourTrimPojo findByAnnee(int annee) {
        TaxeSejourTrim sejourTrim = taxeSejourTrimRepository.findByAnnee(annee);
        return taxeSejourTrimConverter.toPojo(sejourTrim);
    }

    @Override
    public boolean existsByAnneeAndNumTrim(int annee, int numTrim) {
        return taxeSejourTrimRepository.existsByAnneeAndNumTrim(annee, numTrim);
    }


    @Override
    public TaxeSejourTrimPojo save(TaxeSejourTrimPojo taxeSejourTrimPojo) {
        log.info("data recived {}", taxeSejourTrimPojo);
        TaxeSejourTrim sejourTrim = taxeSejourTrimConverter.toEntity(taxeSejourTrimPojo);
        sejourTrim.setDatePresentation(new Date());
        log.info("after  convert {}", sejourTrim);
        TaxeSejourTrim sejourTrimSaved = taxeSejourTrimRepository.save(sejourTrim);
        return taxeSejourTrimConverter.toPojo(sejourTrimSaved);
    }
}
