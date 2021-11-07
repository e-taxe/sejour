package com.fstg.taxesejour.domaine.process.impl;

import com.fstg.taxesejour.domaine.process.facade.TauxTaxeSejourProcess;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxTaxeSejourDao;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import com.fstg.taxesejour.utils.Utils;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

@Slf4j
public class TauxTaxeSejourProcessImpl implements TauxTaxeSejourProcess {

    private final TauxTaxeSejourDao tauxTaxeSejourDao;

    public TauxTaxeSejourProcessImpl(TauxTaxeSejourDao tauxTaxeSejourDao) {
        this.tauxTaxeSejourDao = tauxTaxeSejourDao;
    }

    private boolean validate(TauxTaxeSejour tauxTaxeSejour, Result result) {
        if (tauxTaxeSejourDao.existsByRef(tauxTaxeSejour.getRef())) {
            result.getErrors().add("taux taxe with ref " + tauxTaxeSejour.getRef() + " already exist");
        }
        if (!Utils.isAfter(tauxTaxeSejour.getDateMinApplication(), tauxTaxeSejour.getDateMaxApplication())) {
            result.getErrors().add("date max should be after date min");
        }

        return result.getErrors().isEmpty();
    }

    @Override
    public Result run(TauxTaxeSejour tauxTaxeSejour) {
        Result result = new Result();
        if (validate(tauxTaxeSejour, result)) {
            tauxTaxeSejourDao.save(tauxTaxeSejour);
            result.getInfos().add("new Taux Taxe Added");
        }
        TauxTaxeSejour tauxTaxeSejour1 = tauxTaxeSejourDao.getCurrentTauxTaxe(Utils.dateToString(new Date()));
        System.out.println("id taux taxe " + tauxTaxeSejour1.getId());
        return result;
    }

    @Override
    public List<TauxTaxeSejour> findAll() {
        return tauxTaxeSejourDao.findAll();
    }


}
