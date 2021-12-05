package com.fstg.taxesejour.infrastructure.dao.repository;

import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TauxTaxeSejourRepository extends JpaRepository<TauxTaxeSejour, Long> {
    TauxTaxeSejour findByRef(String ref);

    int deleteByRef(String ref);

    boolean existsByRef(String ref);

    // JPQL
//    @Query("SELECT t From TauxTaxeSejour t WHERE  t.dateMinApplication<:date AND  t.dateMaxApplication >:date")
//    TauxTaxeSejour getTauxByCurrnetDate(String date);

    @Query(value = "SELECT * From taux_taxe_sejour  WHERE  taux_taxe_sejour.date_min_application<:date AND  taux_taxe_sejour.date_max_application >:date",nativeQuery = true)
    TauxTaxeSejour getTauxByCurrnetDate(String date);


}
