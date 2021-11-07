package com.fstg.taxesejour.infrastructure.dao.repository;

import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SpringTauxTaxeSejourDao extends JpaRepository<TauxTaxeSejour, Long> {
    List<TauxTaxeSejour> findAll();

    TauxTaxeSejour findByRef(String ref);

    int deleteByRef(String ref);

    boolean existsByRef(String ref);

    //    SELECT *
//    FROM TABLE_NAME
//    WHERE
//    dob BETWEEN '1/21/2012' AND '2/22/2012'
    @Query(value = "select dateMaxApplication,dateMaxApplication from tauxTaxeSejour :date between dateMinApplication AND dateMaxApplication", nativeQuery = true)
    TauxTaxeSejour getCurrentTauxTaxe(Date date);


}
