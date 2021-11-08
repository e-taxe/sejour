package com.fstg.taxesejour.domaine.taxeSejourAnnuel.create;

import com.fstg.taxesejour.domaine.core.AbstractProcessImpl;
import com.fstg.taxesejour.domaine.core.Result;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxTaxeSejourInfra;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourAnnuelInfra;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourAnnuele;
import com.fstg.taxesejour.infrastructure.required.LocalService;

public class CreateTaxeAnnuelProcessImpl extends AbstractProcessImpl<CreateTaxeAnnuelInput> implements CreateTaxeAnnuelProcess {
    private final TaxeSejourAnnuelInfra taxeSejourAnnuelInfra;
    private final TauxTaxeSejourInfra tauxTaxeSejourInfra;
    private TauxTaxeSejour tauxTaxeSejour;
    private TaxeSejourAnnuele taxeSejourAnnuele;
    private final LocalService localService;

    public CreateTaxeAnnuelProcessImpl(TaxeSejourAnnuelInfra taxeSejourAnnuelInfra, TauxTaxeSejourInfra tauxTaxeSejourInfra, LocalService localService) {
        this.taxeSejourAnnuelInfra = taxeSejourAnnuelInfra;
        this.tauxTaxeSejourInfra = tauxTaxeSejourInfra;
        this.localService = localService;
    }

    @Override
    public void validate(CreateTaxeAnnuelInput abstractProcessInput, Result result) {
        if (taxeSejourAnnuelInfra.existsByRef(abstractProcessInput.getTaxeSejourAnnuelDto().getRef())) {
            result.addErrorMessage(taxeSejourAnnuelInfra.getMessage("taxe.annuel.notFound"));
        }
        if (taxeSejourAnnuelInfra.findByAnnee(abstractProcessInput.getTaxeSejourAnnuelDto().getAnnee()) != null) {
            result.addErrorMessage(taxeSejourAnnuelInfra.getMessage("taxe.annuel.alreadyEsiste"));
        }
        if (!localService.existByRef(abstractProcessInput.getTaxeSejourAnnuelDto().getRefLocal())) {
            result.addErrorMessage(taxeSejourAnnuelInfra.getMessage("local.notFound"));
        }
    }

    @Override
    public void run(CreateTaxeAnnuelInput abstractProcessInput, Result result) {
        result.addInfoMessage(taxeSejourAnnuelInfra.getMessage("taxe.annuel.create"));
    }
}
