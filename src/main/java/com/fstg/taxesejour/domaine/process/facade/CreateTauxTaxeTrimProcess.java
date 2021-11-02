package com.fstg.taxesejour.domaine.process.facade;

import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.domaine.process.impl.Result;

public interface CreateTauxTaxeTrimProcess {
    public Result run(TaxeSejourTrimPojo taxeSejourTrimPojo);
}
