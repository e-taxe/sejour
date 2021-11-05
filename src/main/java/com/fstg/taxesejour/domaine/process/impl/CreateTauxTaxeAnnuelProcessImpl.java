package com.fstg.taxesejour.domaine.process.impl;

import com.fstg.taxesejour.domaine.pojo.TaxeSejourAnnuelePojo;
import com.fstg.taxesejour.domaine.process.facade.CreateTauxTaxeAnnuelProcess;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxTaxeSejourDao;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourAnnuelDao;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourAnnuele;
import com.fstg.taxesejour.infrastructure.required.LocalService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateTauxTaxeAnnuelProcessImpl implements CreateTauxTaxeAnnuelProcess {
    private final TaxeSejourAnnuelDao taxeSejourAnnuelDao;
    private final TauxTaxeSejourDao tauxTaxeSejourDao;
    private TauxTaxeSejour tauxTaxeSejour;
    private TaxeSejourAnnuele taxeSejourAnnuele;
    private final LocalService localService;

    public CreateTauxTaxeAnnuelProcessImpl(TaxeSejourAnnuelDao taxeSejourAnnuelDao, TauxTaxeSejourDao tauxTaxeSejourDao, LocalService localService) {
        this.taxeSejourAnnuelDao = taxeSejourAnnuelDao;
        this.tauxTaxeSejourDao = tauxTaxeSejourDao;
        this.localService = localService;
    }

    private boolean validate(TaxeSejourAnnuelePojo taxeSejourAnnuelePojo, Result result) {
        if (taxeSejourAnnuelDao.existsByRef(taxeSejourAnnuelePojo.getRef())) {
            result.getErrors().add("taxeSejourAnnuele with ref " + taxeSejourAnnuelePojo.getRef() + "  already existe");
        }
        if (taxeSejourAnnuelDao.findByAnnee(taxeSejourAnnuelePojo.getAnnee()) != null) {
            result.getErrors().add("taxeSejourAnnuele in   " + taxeSejourAnnuelePojo.getAnnee() + "  already existe");
        }
        if (!localService.existByRef(taxeSejourAnnuelePojo.getRefLocal())) {
            result.getErrors().add("local  is not exsite by ref  " + taxeSejourAnnuelePojo.getRefLocal());
        }
        return result.getErrors().isEmpty();
    }

    @Override
    public Result run(TaxeSejourAnnuelePojo taxeSejourAnnuelePojo) {
        Result result = new Result();
        if (validate(taxeSejourAnnuelePojo, result)) {
            log.info("data {} ", taxeSejourAnnuelePojo);
        }
        return result;
    }
}
