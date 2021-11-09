package com.fstg.taxesejour.infrastructure.dao.facade;

import com.fstg.taxesejour.infrastructure.entity.TauxRetardTaxeSejourTrim;

public interface TauxRetardTaxeSejourTrimInfra extends AbstractInfra<TauxRetardTaxeSejourTrim, Long> {
    TauxRetardTaxeSejourTrim findByRef(String ref);

    int deleteByRef(String ref);

    boolean existsByRef(String ref);
    TauxRetardTaxeSejourTrim getTauxByCurrnetDate(String date);
}
