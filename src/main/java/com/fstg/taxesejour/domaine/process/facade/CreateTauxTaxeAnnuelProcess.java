package com.fstg.taxesejour.domaine.process.facade;

import com.fstg.taxesejour.domaine.pojo.TaxeSejourAnnuelePojo;
import com.fstg.taxesejour.domaine.process.impl.Result;

public interface CreateTauxTaxeAnnuelProcess {
    public Result run(TaxeSejourAnnuelePojo taxeSejourAnnuelePojo);
}
