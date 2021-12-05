package com.fstg.taxesejour.infrastructure.dao.facade;

import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;

public interface TauxTaxeSejourInfra extends AbstractInfra<TauxTaxeSejour> {
    TauxTaxeSejour findByRef(String ref);

    int deleteByRef(String ref);

    boolean existsByRef(String ref);

    TauxTaxeSejour getCurrentTauxTaxe(String date);
}
