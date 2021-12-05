package com.fstg.taxesejour.domaine.process.taxeSejourTrim.create;

import com.fstg.taxesejour.domaine.core.AbstractProcessImpl;
import com.fstg.taxesejour.domaine.core.Result;
import com.fstg.taxesejour.domaine.pojo.Local;
import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxRetardTaxeSejourTrimInfra;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxTaxeSejourInfra;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourTrimInfra;
import com.fstg.taxesejour.infrastructure.entity.TauxRetardTaxeSejourTrim;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import com.fstg.taxesejour.infrastructure.messaging.LocalMessageReader;
import com.fstg.taxesejour.infrastructure.required.LocalService;
import com.fstg.taxesejour.utils.Utils;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class CreateTaxeTrimProcessImpl extends AbstractProcessImpl<TaxeSejourTrimPojo> implements CreateTaxeTrimProcess {

    private TauxTaxeSejour tauxTaxeSejour;
    private TauxRetardTaxeSejourTrim tauxRetardTaxeSejourTrim;
    private final TaxeSejourTrimInfra taxeSejourTrimInfra;
    private final TauxTaxeSejourInfra tauxTaxeSejourInfra;
    private final TauxRetardTaxeSejourTrimInfra tauxRetardTaxeSejourTrimInfra;
    private final LocalService localService;
    private final LocalMessageReader localMessageReader;

    public CreateTaxeTrimProcessImpl(TaxeSejourTrimInfra taxeSejourTrimInfra, TauxTaxeSejourInfra tauxTaxeSejourInfra,
                                     TauxRetardTaxeSejourTrimInfra tauxRetardTaxeSejourTrimInfra, LocalService localService, LocalMessageReader localMessageReader) {
        this.taxeSejourTrimInfra = taxeSejourTrimInfra;
        this.tauxTaxeSejourInfra = tauxTaxeSejourInfra;
        this.tauxRetardTaxeSejourTrimInfra = tauxRetardTaxeSejourTrimInfra;
        this.localService = localService;
        this.localMessageReader = localMessageReader;
    }

    @Override
    public void validate(TaxeSejourTrimPojo createTaxeTrimInput, Result result) {
        if (!localService.existByRef(createTaxeTrimInput.getRefLocal())) {
            result.addErrorMessage(localMessageReader.getMessage("local.not-found"));
        }
        if (taxeSejourTrimInfra.existeByRef(createTaxeTrimInput.getRef())) {
            result.addErrorMessage(localMessageReader.getMessage("taxe.trim.alreadyEsiste"));
        }
        if (taxeSejourTrimInfra.existsByAnneeAndNumTrim(createTaxeTrimInput.getAnnee(), createTaxeTrimInput.getNumTrim())) {
            result.addErrorMessage(localMessageReader.getMessage("taxe.trim.alreadyEsiste"));
        }
        tauxTaxeSejour = tauxTaxeSejourInfra.getCurrentTauxTaxe(Utils.dateToString(new Date()));
        if (tauxTaxeSejour == null) {
            result.addErrorMessage(localMessageReader.getMessage("taux-taxe-retard.trim.notfoud"));
        }
        tauxRetardTaxeSejourTrim = tauxRetardTaxeSejourTrimInfra.getTauxByCurrnetDate(Utils.dateToString(new Date()));
        if (tauxRetardTaxeSejourTrim == null) {
            result.addErrorMessage(localMessageReader.getMessage("taux-taxe-retard.trim.notfoud"));
        }
    }

    @Override
    public void run(TaxeSejourTrimPojo taxeSejourTrimPojo, Result result) {

        int nombreMoisRetard = Utils.getNumberOfMonthRetard(
                taxeSejourTrimPojo.getNumTrim(),
                taxeSejourTrimPojo.getAnnee());
        Utils.getMontant(
                tauxTaxeSejour.getTaux(),
                taxeSejourTrimPojo,
                tauxRetardTaxeSejourTrim.getPremierMoisRetard(),
                tauxRetardTaxeSejourTrim.getAutreMoisRetard(),
                taxeSejourTrimPojo.getNombreNuit(),
                nombreMoisRetard);
        taxeSejourTrimInfra.save(taxeSejourTrimPojo);

        result.addInfoMessage(localMessageReader.getMessage("taxe-sejour-trim.created"), 201);
        Local local = new Local();
        local.setAnnee(taxeSejourTrimPojo.getAnnee());
        local.setTrim(taxeSejourTrimPojo.getNumTrim());
        local.setRef(taxeSejourTrimPojo.getRefLocal());
        localService.update(local);
        result.addInfoMessage(localMessageReader.getMessage("local.updated"), 202);

    }


}
