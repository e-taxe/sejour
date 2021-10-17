package com.fstg.taxesejour.infrastructure.dao;

import com.fstg.taxesejour.infrastructure.entity.TaxeSejourAnnuele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxeSejourAnnueleDao extends JpaRepository<TaxeSejourAnnuele, Long> {
}
