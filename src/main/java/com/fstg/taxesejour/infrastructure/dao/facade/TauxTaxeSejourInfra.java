package com.fstg.taxesejour.infrastructure.dao.facade;

import com.fstg.taxesejour.domaine.pojo.TauxTaxeSejourPojo;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;

public interface TauxTaxeSejourInfra extends AbstractInfra<TauxTaxeSejour> {
    TauxTaxeSejour findByRef(String ref);

    int deleteByRef(String ref);

    boolean existsByRef(String ref);

    TauxTaxeSejourPojo getCurrentTauxTaxe(String date);
}
