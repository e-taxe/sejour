package com.fstg.taxesejour.domaine.serviceImpl;

import com.fstg.taxesejour.domaine.pojo.TaxeSejourAnnuelePojo;
import com.fstg.taxesejour.domaine.service.core.TaxeSejourAnnuelService;
import com.fstg.taxesejour.infrastructure.dao.TaxeSejourAnnuelDao;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourAnnuele;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TaxeSejourAnnuelServiceImpl implements TaxeSejourAnnuelService {
    private final TaxeSejourAnnuelDao taxeSejourAnnuelDao;
    private final ModelMapper modelMapper;

    public TaxeSejourAnnuelServiceImpl(TaxeSejourAnnuelDao taxeSejourAnnuelDao, ModelMapper modelMapper) {
        this.taxeSejourAnnuelDao = taxeSejourAnnuelDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public TaxeSejourAnnuelePojo save(TaxeSejourAnnuele taxeSejourAnnuele) {
        log.info("taxeSejourAnnuele {}", taxeSejourAnnuele);
        return modelMapper.map(taxeSejourAnnuelDao.save(taxeSejourAnnuele), TaxeSejourAnnuelePojo.class);
    }

    @Override
    public List<TaxeSejourAnnuelePojo> findAll() {
        return taxeSejourAnnuelDao.findAll().stream()
                .map(el -> modelMapper.map(el, TaxeSejourAnnuelePojo.class))
                .collect(Collectors.toList());
    }

    @Override
    public TaxeSejourAnnuelePojo findByRef(String ref) {
        TaxeSejourAnnuele taxeSejourAnnuele = taxeSejourAnnuelDao.findByRef(ref);
        if (taxeSejourAnnuele != null) return modelMapper.map(taxeSejourAnnuele, TaxeSejourAnnuelePojo.class);
        return null;
    }

    @Override
    public TaxeSejourAnnuelePojo findByAnnee(int annee) {
        TaxeSejourAnnuele taxeSejourAnnuele = taxeSejourAnnuelDao.findByAnnee(annee);
        if (taxeSejourAnnuele != null) return modelMapper.map(taxeSejourAnnuele, TaxeSejourAnnuelePojo.class);
        return null;
    }
}
