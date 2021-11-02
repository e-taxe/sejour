package com.fstg.taxesejour.domaine.process.impl;

import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.domaine.process.facade.CreateTauxTaxeTrimProcess;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxRetardTaxeSejourTrimDao;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxTaxeSejourDao;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourAnnuelDao;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourTrimDao;
import com.fstg.taxesejour.infrastructure.entity.TauxRetardTaxeSejourTrim;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import com.fstg.taxesejour.utils.Utils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateTauxTaxeTrimProcessImpl implements CreateTauxTaxeTrimProcess {

    private final TaxeSejourTrimDao taxeSejourTrimDao;
    private final TaxeSejourAnnuelDao taxeSejourAnnuelDao;
    private final TauxTaxeSejourDao tauxTaxeSejourDao;
    private final TauxRetardTaxeSejourTrimDao tauxRetardTaxeSejourTrimDao;
    private TauxTaxeSejour tauxTaxeSejour;

    public CreateTauxTaxeTrimProcessImpl(TaxeSejourTrimDao taxeSejourTrimDao, TaxeSejourAnnuelDao taxeSejourAnnuelDao, TauxTaxeSejourDao tauxTaxeSejourDao, TauxRetardTaxeSejourTrimDao tauxRetardTaxeSejourTrimDao) {
        this.taxeSejourTrimDao = taxeSejourTrimDao;
        this.taxeSejourAnnuelDao = taxeSejourAnnuelDao;
        this.tauxTaxeSejourDao = tauxTaxeSejourDao;
        this.tauxRetardTaxeSejourTrimDao = tauxRetardTaxeSejourTrimDao;
    }

    //    TaxeSejourTrim taxeSejourTrim = taxeSejourTrimConverter.voToBean(taxeSejourTrimDtoRequest);
////        taxeSejourTrim.setDatePresentation(new Date());
//        if (taxeSejourTrimDao.existeByRef(taxeSejourTrim.getRef())) return -1;
//    /* test if taxeSejourAnnuel existe By ref */
//    //TODO add code here
//    /* test if taxeSejourTrim existe by annee and num trim  */
//        if (taxeSejourTrimDao.existsByAnneeAndNumTrim(taxeSejourTrim.getAnnee(), taxeSejourTrim.getNumTrim()))
//                return -2;
//    /* Calcul Montant */
//    int daysRetard = Utils.getNumberDaysRetard(taxeSejourTrim.getDatePresentation(), taxeSejourTrim.getExpectedDatePresentation());
//    /* calcul montant retard */
//        System.out.println("nombrredays retard " + daysRetard);
//        taxeSejourTrimDao.save(taxeSejourTrim);
//        return 1;

    private boolean validate(TaxeSejourTrimPojo taxeSejourTrimPojo, Result result) {
        if (!taxeSejourAnnuelDao.existsByRef(taxeSejourTrimPojo.getRefTaxeSejourAnnuele())) {
            result.getErrors().add("Taxe Sejour Annuele with ref " + taxeSejourTrimPojo.getRefTaxeSejourAnnuele() + " Innexistant");
        }
        tauxTaxeSejour = tauxTaxeSejourDao.findByRef(taxeSejourTrimPojo.getRefTauxTaxe());
        if (tauxTaxeSejour == null) {
            result.getErrors().add("Taux Taxe Sejour  with ref " + taxeSejourTrimPojo.getRefTauxTaxe() + " Innexistant");
        }
        if (taxeSejourTrimDao.existeByRef(taxeSejourTrimPojo.getRef())) {
            result.getErrors().add("taxe Sejour Trim with " + taxeSejourTrimPojo.getRef() + "  already existe ");
        }
        if (taxeSejourTrimDao.existsByAnneeAndNumTrim(taxeSejourTrimPojo.getAnnee(), taxeSejourTrimPojo.getNumTrim())) {
            result.getErrors().add("taxe Sejour Trim " + taxeSejourTrimPojo.getNumTrim() + " already existe");
        }
        return result.getErrors().isEmpty();
    }

    @Override
    public Result run(TaxeSejourTrimPojo taxeSejourTrimPojo) {
        Result result = new Result();
        if (validate(taxeSejourTrimPojo, result)) {
            int monthRetard = Utils.getNumberOfMonthRetard(taxeSejourTrimPojo.getDatePresentation(), taxeSejourTrimPojo.getExpectedDatePresentation());
            //TODO GET Taux Taxe Sejour
//            this.tauxTaxeSejour.
            // TODO TEST 3LA RETARD AND calculate montant retard
            // TODO create Objet retard for this trim
            // calculute Total Montant
            //taxeSejourTrimDao.save()
            TauxRetardTaxeSejourTrim tauxRetardTaxeSejourTrim = Utils.calculateMontant(monthRetard, this.tauxTaxeSejour.getTaux(), 2d, taxeSejourTrimPojo.getNombreNuit());
            log.info("****************** {}", tauxRetardTaxeSejourTrim);
            result.getInfos().add("pret a ajouter  nombre de month retard est " + monthRetard);
        }
        return result;
    }
//    TODO CREATE PAIMENT PROCESS OF TAXE ANNUELE
//    TODO CREATE PAIEMENT PROCESS OF TAXE TRIM
}
