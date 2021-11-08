package com.fstg.taxesejour.domaine.taxeSejourTrim.create;

import com.fstg.taxesejour.domaine.core.AbstractProcessImpl;
import com.fstg.taxesejour.domaine.core.Result;
import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxRetardTaxeSejourTrimInfra;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxTaxeSejourInfra;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourAnnuelInfra;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourTrimInfra;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourAnnuele;
import com.fstg.taxesejour.utils.Utils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateTaxeTrimProcessImpl extends AbstractProcessImpl<CreateTaxeTrimInput> implements CreateTaxeTrimProcess {

    private TauxTaxeSejour tauxTaxeSejour;
    private TaxeSejourAnnuele taxeSejourAnnuele;
    private TaxeSejourTrimPojo taxeSejourTrimPojo;
    private final TaxeSejourTrimInfra taxeSejourTrimInfra;
    private final TaxeSejourAnnuelInfra taxeSejourAnnuelInfra;
    private final TauxTaxeSejourInfra tauxTaxeSejourInfra;
    private final TauxRetardTaxeSejourTrimInfra tauxRetardTaxeSejourTrimInfra;

    public CreateTaxeTrimProcessImpl(TaxeSejourTrimInfra taxeSejourTrimInfra, TaxeSejourAnnuelInfra taxeSejourAnnuelInfra, TauxTaxeSejourInfra tauxTaxeSejourInfra, TauxRetardTaxeSejourTrimInfra tauxRetardTaxeSejourTrimInfra) {
        this.taxeSejourTrimInfra = taxeSejourTrimInfra;
        this.taxeSejourAnnuelInfra = taxeSejourAnnuelInfra;
        this.tauxTaxeSejourInfra = tauxTaxeSejourInfra;
        this.tauxRetardTaxeSejourTrimInfra = tauxRetardTaxeSejourTrimInfra;
    }

    @Override
    public void validate(CreateTaxeTrimInput abstractProcessInput, Result result) {
        taxeSejourTrimPojo = abstractProcessInput.getTaxeSejourTrimPojo();
        int monthRetard = Utils.getNumberOfMonthRetard(taxeSejourTrimPojo.getDatePresentation(), taxeSejourTrimPojo.getNumTrim(), taxeSejourTrimPojo.getAnnee());
        log.info("nombre de mois retard est :" + monthRetard);
        if (monthRetard > 0) {
//            TODO CALCULE MONTANT AND MONTANT RETARD
        }
//        taxeSejourTrimPojo = abstractProcessInput.getTaxeSejourTrimPojo();
//        taxeSejourAnnuele = taxeSejourAnnuelInfra.findByRef(taxeSejourTrimPojo.getRef());
//        if (taxeSejourAnnuele == null) {
//            result.addErrorMessage(taxeSejourTrimInfra.getMessage("taxe.annuel.notFound"));
//        }
//        tauxTaxeSejour = tauxTaxeSejourInfra.findByRef(taxeSejourTrimPojo.getRefTauxTaxe());
//        if (tauxTaxeSejour == null) {
//            result.addErrorMessage(taxeSejourTrimInfra.getMessage("taux.taxe.notfound"));
//        }
//        if (taxeSejourTrimInfra.existeByRef(taxeSejourTrimPojo.getRef())) {
//            result.addErrorMessage(taxeSejourTrimInfra.getMessage("taxe.trim.alreadyEsiste"));
//        }
//        if (taxeSejourTrimInfra.existsByAnneeAndNumTrim(taxeSejourTrimPojo.getAnnee(), taxeSejourTrimPojo.getNumTrim())) {
//            result.addErrorMessage(taxeSejourTrimInfra.getMessage("taxe.trim.alreadyEsiste"));
//        }
    }

    @Override
    public void run(CreateTaxeTrimInput abstractProcessInput, Result result) {
        int monthRetard = Utils.getNumberOfMonthRetard(taxeSejourTrimPojo.getDatePresentation(), taxeSejourTrimPojo.getNumTrim(), taxeSejourTrimPojo.getAnnee());
//        BigDecimal montant = BigDecimal.valueOf(this.tauxTaxeSejour.getTaux() * taxeSejourTrimPojo.getNombreNuit());
//        TauxRetardTaxeSejourTrim tauxRetardTaxeSejourTrim =
//                Utils.calculateMontant(monthRetard, this.tauxTaxeSejour.getTaux(), 2d, taxeSejourTrimPojo.getNombreNuit());
//        tauxRetardTaxeSejourTrimInfra.save(tauxRetardTaxeSejourTrim);
//        TaxeSejourTrim taxeSejourTrim = TaxeSejourTrim.builder()
//                .numTrim(taxeSejourTrimPojo.getNumTrim())
//                .montant(montant)
//                .datePresentation(new Date())
//                .annee(taxeSejourTrimPojo.getAnnee())
//                .tauxRetardTaxeSejourTrim(tauxRetardTaxeSejourTrim)
//                .ref(taxeSejourTrimPojo.getRef())
//                .taxeSejourAnnuele(taxeSejourAnnuele)
//                .nombreNuit(BigDecimal.valueOf(taxeSejourTrimPojo.getNombreNuit()))
//                .tauxTaxeSejour(tauxTaxeSejour)
//                .build();
//        taxeSejourTrimInfra.save(taxeSejourTrim);
//            TODO UPDATE LOCAL LAST YEAR PAYE AND LAST TRIM
    }


}
