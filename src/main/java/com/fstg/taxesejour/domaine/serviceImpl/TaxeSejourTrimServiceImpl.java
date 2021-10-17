package com.fstg.taxesejour.domaine.serviceImpl;

import com.fstg.taxesejour.application.dto.TaxeSejourTrimDtoRequest;
import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.domaine.service.core.TaxeSejourTrimService;
import com.fstg.taxesejour.infrastructure.dao.TaxeSejourTrimDao;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourTrim;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class TaxeSejourTrimServiceImpl implements TaxeSejourTrimService {

    private final TaxeSejourTrimDao taxeSejourTrimDao;
    private final ModelMapper modelMapper;

    public TaxeSejourTrimServiceImpl(TaxeSejourTrimDao taxeSejourTrimDao, ModelMapper modelMapper) {
        this.taxeSejourTrimDao = taxeSejourTrimDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TaxeSejourTrimPojo> findAll() {
        return taxeSejourTrimDao.findAll().stream()
                .map(el -> modelMapper.map(el, TaxeSejourTrimPojo.class))
                .collect(Collectors.toList());
    }

    @Override
    public TaxeSejourTrimPojo findByRefTaxeSejourTrim(String refTaxeSejourTrim) {
        return modelMapper.map(taxeSejourTrimDao.findByRefTaxeSejourTrim(refTaxeSejourTrim), TaxeSejourTrimPojo.class);
    }

    @Override
    public int deleteByRefTaxeSejourTrim(String refTaxeSejourTrim) {
        return taxeSejourTrimDao.deleteByRefTaxeSejourTrim(refTaxeSejourTrim);
    }

    @Override
    public TaxeSejourTrimPojo findByAnnee(int annee) {
        return modelMapper.map(taxeSejourTrimDao.findByAnnee(annee), TaxeSejourTrimPojo.class);
    }

    @Override
    public TaxeSejourTrimPojo findByDateValidation(Date dateValidation) {
        return modelMapper.map(taxeSejourTrimDao.findByDateValidation(dateValidation), TaxeSejourTrimPojo.class);
    }

    @Override
    public TaxeSejourTrimPojo save(TaxeSejourTrimDtoRequest taxeSejourTrimDtoRequest) {
        TaxeSejourTrim taxeSejourTrim = modelMapper.map(taxeSejourTrimDtoRequest, TaxeSejourTrim.class);
        log.info("taxe sejour Trim {}", taxeSejourTrim);
        return null;

    }


}
