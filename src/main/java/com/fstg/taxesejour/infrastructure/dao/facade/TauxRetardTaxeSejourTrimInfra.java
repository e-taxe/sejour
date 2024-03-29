package com.fstg.taxesejour.infrastructure.dao.facade;

import com.fstg.taxesejour.domaine.pojo.TauxRetardTaxeSejourTrimPojo;
import com.fstg.taxesejour.infrastructure.entity.TauxRetardTaxeSejourTrim;

public interface TauxRetardTaxeSejourTrimInfra extends AbstractInfra<TauxRetardTaxeSejourTrim> {
    TauxRetardTaxeSejourTrim findByRef(String ref);

    int deleteByRef(String ref);

    boolean existsByRef(String ref);
    TauxRetardTaxeSejourTrimPojo getTauxByCurrnetDate(String date);
}
