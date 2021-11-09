package com.fstg.taxesejour.domaine.taxeSejourTrim.create;

import com.fstg.taxesejour.domaine.core.AbstractProcessImpl;
import com.fstg.taxesejour.domaine.core.Result;
import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxRetardTaxeSejourTrimInfra;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxTaxeSejourInfra;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourTrimInfra;
import com.fstg.taxesejour.infrastructure.entity.TauxRetardTaxeSejourTrim;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import com.fstg.taxesejour.utils.Utils;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class CreateTaxeTrimProcessImpl extends AbstractProcessImpl<CreateTaxeTrimInput> implements CreateTaxeTrimProcess {

    private TauxTaxeSejour tauxTaxeSejour;
    private TauxRetardTaxeSejourTrim tauxRetardTaxeSejourTrim;
    private TaxeSejourTrimPojo taxeSejourTrimPojo;
    private final TaxeSejourTrimInfra taxeSejourTrimInfra;
    private final TauxTaxeSejourInfra tauxTaxeSejourInfra;
    private final TauxRetardTaxeSejourTrimInfra tauxRetardTaxeSejourTrimInfra;

    public CreateTaxeTrimProcessImpl(TaxeSejourTrimInfra taxeSejourTrimInfra, TauxTaxeSejourInfra tauxTaxeSejourInfra, TauxRetardTaxeSejourTrimInfra tauxRetardTaxeSejourTrimInfra) {
        this.taxeSejourTrimInfra = taxeSejourTrimInfra;
        this.tauxTaxeSejourInfra = tauxTaxeSejourInfra;
        this.tauxRetardTaxeSejourTrimInfra = tauxRetardTaxeSejourTrimInfra;
    }

    @Override
    public void validate(CreateTaxeTrimInput abstractProcessInput, Result result) {
        taxeSejourTrimPojo = abstractProcessInput.getTaxeSejourTrimPojo();
        if (taxeSejourTrimInfra.existeByRef(taxeSejourTrimPojo.getRef())) {
            result.addErrorMessage(taxeSejourTrimInfra.getMessage("taxe.trim.alreadyEsiste"));
        }
        if (taxeSejourTrimInfra.existsByAnneeAndNumTrim(taxeSejourTrimPojo.getAnnee(), taxeSejourTrimPojo.getNumTrim())) {
            result.addErrorMessage(taxeSejourTrimInfra.getMessage("taxe.trim.alreadyEsiste"));
        }
        tauxTaxeSejour = tauxTaxeSejourInfra.getCurrentTauxTaxe(Utils.dateToString(new Date()));
        if (tauxTaxeSejour == null) {
            result.addErrorMessage(taxeSejourTrimInfra.getMessage("taux-taxe-retard.trim.notfoud"));
        }
        tauxRetardTaxeSejourTrim = tauxRetardTaxeSejourTrimInfra.getTauxByCurrnetDate(Utils.dateToString(new Date()));
        if (tauxRetardTaxeSejourTrim == null) {
            result.addErrorMessage(taxeSejourTrimInfra.getMessage("taux-taxe-retard.trim.notfoud"));
        }
    }

    @Override
    public void run(CreateTaxeTrimInput abstractProcessInput, Result result) {
        int nombreMoisRetard = Utils.getNumberOfMonthRetard(abstractProcessInput.getTaxeSejourTrimPojo());
        taxeSejourTrimPojo = Utils.getMontant(tauxTaxeSejour.getTaux(), taxeSejourTrimPojo, tauxRetardTaxeSejourTrim.getPremierMoisRetard(),
                tauxRetardTaxeSejourTrim.getAutreMoisRetard(), nombreMoisRetard);
        log.info("objet taxe sejour {}", taxeSejourTrimPojo);
        taxeSejourTrimInfra.save(taxeSejourTrimPojo);
        result.addInfoMessage(taxeSejourTrimInfra.getMessage("taxe-sejour-trim.created"));
    }


}
