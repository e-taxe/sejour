package com.fstg.taxesejour.infrastructure.dao.impl;

import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.infrastructure.converter.TaxeSejourTrimConverter;
import com.fstg.taxesejour.infrastructure.core.AbstractInfraImpl;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourTrimInfra;
import com.fstg.taxesejour.infrastructure.dao.repository.SpringDataTaxeSejourTrimDao;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourTrim;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class SpringTaxeSejourTrimService extends AbstractInfraImpl implements TaxeSejourTrimInfra {
    private final SpringDataTaxeSejourTrimDao springDataTaxeSejourTrimDao;
    private final TaxeSejourTrimConverter taxeSejourTrimConverter;


    public SpringTaxeSejourTrimService(SpringDataTaxeSejourTrimDao springDataTaxeSejourTrimDao, TaxeSejourTrimConverter taxeSejourTrimConverter) {
        this.springDataTaxeSejourTrimDao = springDataTaxeSejourTrimDao;

        this.taxeSejourTrimConverter = taxeSejourTrimConverter;
    }

    @Override
    public List<TaxeSejourTrimPojo> findAll() {
        return springDataTaxeSejourTrimDao.findAll().stream().map(taxeSejourTrimConverter::toPojo).collect(Collectors.toList());
    }


    @Override
    public TaxeSejourTrimPojo findByRef(String ref) {
        TaxeSejourTrim sejourTrim = springDataTaxeSejourTrimDao.findByRef(ref);
        return taxeSejourTrimConverter.toPojo(sejourTrim);
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
    public TaxeSejourTrimPojo findByAnnee(int annee) {
        TaxeSejourTrim sejourTrim = springDataTaxeSejourTrimDao.findByAnnee(annee);
        return taxeSejourTrimConverter.toPojo(sejourTrim);
    }

    @Override
    public boolean existsByAnneeAndNumTrim(int annee, int numTrim) {
        return springDataTaxeSejourTrimDao.existsByAnneeAndNumTrim(annee, numTrim);
    }


    @Override
    public TaxeSejourTrimPojo save(TaxeSejourTrimPojo taxeSejourTrimPojo) {
        log.info("data recived {}", taxeSejourTrimPojo);
        TaxeSejourTrim sejourTrim = taxeSejourTrimConverter.toEntity(taxeSejourTrimPojo);
        log.info("after  convert {}", sejourTrim);
        TaxeSejourTrim sejourTrimSaved = springDataTaxeSejourTrimDao.save(sejourTrim);
        return taxeSejourTrimConverter.toPojo(sejourTrimSaved);
    }
}
