package com.fstg.taxesejour.domaine.process.impl;

import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourAnnuelDao;
import com.fstg.taxesejour.domaine.process.facade.TaxeSejourAnnuelService;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourAnnuele;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;


public class TaxeSejourAnnuelServiceImpl implements TaxeSejourAnnuelService {
    private final TaxeSejourAnnuelDao taxeSejourAnnuelDao;
    private final ModelMapper modelMapper;


    public TaxeSejourAnnuelServiceImpl(TaxeSejourAnnuelDao taxeSejourAnnuelDao, ModelMapper modelMapper) {
        this.taxeSejourAnnuelDao = taxeSejourAnnuelDao;
        this.modelMapper = modelMapper;

    }

    @Override
    public int save(TaxeSejourAnnuele taxeSejourAnnuele) {
//        if (!localService.existByRef(taxeSejourAnnuele.getRefLocal())) return -1;
        if (taxeSejourAnnuelDao.existsByRef(taxeSejourAnnuele.getRef())) return -2;
        taxeSejourAnnuelDao.save(taxeSejourAnnuele);
        return 1;
    }

    @Override
    public List<TaxeSejourAnnuele> findAll() {
        return taxeSejourAnnuelDao.findAll().stream()
                .map(el -> modelMapper.map(el, TaxeSejourAnnuele.class))
                .collect(Collectors.toList());
    }

    @Override
    public TaxeSejourAnnuele findByRef(String ref) {
        TaxeSejourAnnuele taxeSejourAnnuele = taxeSejourAnnuelDao.findByRef(ref);
        if (taxeSejourAnnuele != null) return modelMapper.map(taxeSejourAnnuele, TaxeSejourAnnuele.class);
        return null;
    }

    @Override
    public boolean existsByRef(String ref) {
        return taxeSejourAnnuelDao.existsByRef(ref);
    }

    @Override
    public int deleteByRef(String ref) {
        return taxeSejourAnnuelDao.deleteByRef(ref);
    }

    @Override
    public TaxeSejourAnnuele findByAnnee(int annee) {
        TaxeSejourAnnuele taxeSejourAnnuele = taxeSejourAnnuelDao.findByAnnee(annee);
        if (taxeSejourAnnuele != null) return modelMapper.map(taxeSejourAnnuele, TaxeSejourAnnuele.class);
        return null;
    }
}
