package com.fstg.taxesejour.infrastructure.dao.facade;

import com.fstg.taxesejour.infrastructure.entity.TauxRetardTaxeSejourTrim;

public interface TauxRetardTaxeSejourTrimDao extends AbstractDao<TauxRetardTaxeSejourTrim, Long> {
    TauxRetardTaxeSejourTrim findByRef(String ref);

    int deleteByRef(String ref);

    boolean existsByRef(String ref);
}
