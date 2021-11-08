package com.fstg.taxesejour.domaine.taxeSejourTrim.create;

import com.fstg.taxesejour.domaine.core.AbstractProcessInput;
import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;

public class CreateTaxeTrimInput extends AbstractProcessInput {
    TaxeSejourTrimPojo taxeSejourTrimPojo;

    public TaxeSejourTrimPojo getTaxeSejourTrimPojo() {
        return taxeSejourTrimPojo;
    }

    public void setTaxeSejourTrimPojo(TaxeSejourTrimPojo taxeSejourTrimPojo) {
        this.taxeSejourTrimPojo = taxeSejourTrimPojo;
    }
}
