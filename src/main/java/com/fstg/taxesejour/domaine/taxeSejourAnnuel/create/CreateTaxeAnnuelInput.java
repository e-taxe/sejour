package com.fstg.taxesejour.domaine.taxeSejourAnnuel.create;

import com.fstg.taxesejour.application.dto.TaxeSejourAnnuelDto;
import com.fstg.taxesejour.domaine.core.AbstractProcessInput;


public class CreateTaxeAnnuelInput extends AbstractProcessInput {
    TaxeSejourAnnuelDto taxeSejourAnnuelDto;

    public TaxeSejourAnnuelDto getTaxeSejourAnnuelDto() {
        return taxeSejourAnnuelDto;
    }

    public void setTaxeSejourAnnuelDto(TaxeSejourAnnuelDto taxeSejourAnnuelDto) {
        this.taxeSejourAnnuelDto = taxeSejourAnnuelDto;
    }

}
