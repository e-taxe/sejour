package com.fstg.taxesejour.domaine.process.impl;

import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.domaine.process.facade.CreateTauxTaxeTrimProcess;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxRetardTaxeSejourTrimDao;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxTaxeSejourDao;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourAnnuelDao;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourTrimDao;
import com.fstg.taxesejour.infrastructure.entity.TauxRetardTaxeSejourTrim;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourAnnuele;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourTrim;
import com.fstg.taxesejour.utils.Utils;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Date;

@Slf4j
public class CreateTauxTaxeTrimProcessImpl implements CreateTauxTaxeTrimProcess {

    private final TaxeSejourTrimDao taxeSejourTrimDao;
    private final TaxeSejourAnnuelDao taxeSejourAnnuelDao;
    private final TauxTaxeSejourDao tauxTaxeSejourDao;
    private final TauxRetardTaxeSejourTrimDao tauxRetardTaxeSejourTrimDao;
    private TauxTaxeSejour tauxTaxeSejour;
    private TaxeSejourAnnuele taxeSejourAnnuele;

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
        taxeSejourAnnuele = taxeSejourAnnuelDao.findByRef(taxeSejourTrimPojo.getRefTaxeSejourAnnuele());
        if (taxeSejourAnnuele == null) {
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
            BigDecimal montant = BigDecimal.valueOf(this.tauxTaxeSejour.getTaux() * taxeSejourTrimPojo.getNombreNuit());
            TauxRetardTaxeSejourTrim tauxRetardTaxeSejourTrim = Utils.calculateMontant(monthRetard, this.tauxTaxeSejour.getTaux(), 2d, taxeSejourTrimPojo.getNombreNuit());
            tauxRetardTaxeSejourTrimDao.save(tauxRetardTaxeSejourTrim);
            TaxeSejourTrim taxeSejourTrim = TaxeSejourTrim.builder()
                    .montantRetard(tauxRetardTaxeSejourTrim.getAutreMoisRetard().add(tauxRetardTaxeSejourTrim.getPremierMoisRetard()))
                    .numTrim(taxeSejourTrimPojo.getNumTrim())
                    .montant(montant)
                    .datePresentation(new Date())
                    .annee(taxeSejourTrimPojo.getAnnee())
                    .tauxRetardTaxeSejourTrim(tauxRetardTaxeSejourTrim)
                    .dateValidation(new Date())
                    .ref(taxeSejourTrimPojo.getRef())
                    .taxeSejourAnnuele(taxeSejourAnnuele)
                    .nombreNuit(BigDecimal.valueOf(taxeSejourTrimPojo.getNombreNuit()))
                    .tauxTaxeSejour(tauxTaxeSejour)
                    .build();
            taxeSejourTrimDao.save(taxeSejourTrim);
//            TODO UPDATE LOCAL LAST YEAR PAYE AND LAST TRIM
            result.getInfos().add("pret a ajouter  nombre de month retard est " + monthRetard);
        }
        return result;
    }
//    TODO CREATE PAIMENT PROCESS OF TAXE ANNUELE
//    TODO CREATE PAIEMENT PROCESS OF TAXE TRIM
}
