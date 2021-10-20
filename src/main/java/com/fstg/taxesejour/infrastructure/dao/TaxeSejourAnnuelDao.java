package com.fstg.taxesejour.infrastructure.dao;

import com.fstg.taxesejour.infrastructure.entity.TaxeSejourAnnuele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxeSejourAnnuelDao extends JpaRepository<TaxeSejourAnnuele, Long> {
    TaxeSejourAnnuele findByRef(String ref);

    TaxeSejourAnnuele findByAnnee(int annee);

}
