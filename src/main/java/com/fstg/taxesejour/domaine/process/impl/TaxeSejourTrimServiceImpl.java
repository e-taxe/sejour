package com.fstg.taxesejour.domaine.process.impl;

import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.domaine.process.facade.TaxeSejourTrimService;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourTrimDao;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourTrim;
import com.fstg.taxesejour.utils.Utils;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        return modelMapper.map(taxeSejourTrimDao.findByRef(refTaxeSejourTrim), TaxeSejourTrimPojo.class);
    }

    @Override
    public int deleteByRefTaxeSejourTrim(String refTaxeSejourTrim) {
        return taxeSejourTrimDao.deleteByRef(refTaxeSejourTrim);
    }

    @Override
    public TaxeSejourTrimPojo findByAnnee(int annee) {
        return modelMapper.map(taxeSejourTrimDao.findByAnnee(annee), TaxeSejourTrimPojo.class);
    }

    @Override
    public boolean existeByRef(String ref) {
        return taxeSejourTrimDao.existeByRef(ref);
    }

    @Override
    public boolean existsByAnneeAndNumTrim(int annee, int numTrim) {
        return taxeSejourTrimDao.existsByAnneeAndNumTrim(annee, numTrim);
    }

    @Override
    public TaxeSejourTrimPojo findByDateValidation(Date dateValidation) {
        return modelMapper.map(taxeSejourTrimDao.findByDateValidation(dateValidation), TaxeSejourTrimPojo.class);
    }


    @Override
    public int save(TaxeSejourTrim taxeSejourTrim) {
//        TaxeSejourTrim taxeSejourTrim = taxeSejourTrimConverter.voToBean(taxeSejourTrimDtoRequest);
//        taxeSejourTrim.setDatePresentation(new Date());
        if (taxeSejourTrimDao.existeByRef(taxeSejourTrim.getRef())) return -1;
        /* test if taxeSejourAnnuel existe By ref */
        //TODO add code here
        /* test if taxeSejourTrim existe by annee and num trim  */
        if (taxeSejourTrimDao.existsByAnneeAndNumTrim(taxeSejourTrim.getAnnee(), taxeSejourTrim.getNumTrim()))
            return -2;
        /* Calcul Montant */
        int daysRetard = Utils.getNumberOfMonthRetard(taxeSejourTrim.getDatePresentation(), taxeSejourTrim.getExpectedDatePresentation());
        /* calcul montant retard */
        System.out.println("nombrredays retard " + daysRetard);
        taxeSejourTrimDao.save(taxeSejourTrim);
        return 1;
    }


}
