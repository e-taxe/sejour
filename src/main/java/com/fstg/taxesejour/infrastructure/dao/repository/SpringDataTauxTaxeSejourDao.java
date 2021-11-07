package com.fstg.taxesejour.infrastructure.dao.repository;

import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataTauxTaxeSejourDao extends JpaRepository<TauxTaxeSejour, Long> {
    TauxTaxeSejour findByRef(String ref);

    int deleteByRef(String ref);

    boolean existsByRef(String ref);

    @Query(value =
            "SELECT * FROM taux_taxe_sejour WHERE date_min_application< :date AND date_max_application > :date",
            nativeQuery = true)
    TauxTaxeSejour getCurrentTauxTaxe(String date);

// JPQL
//    @Query("SELECT a FROM Author a WHERE firstName = ?1 AND lastName = ?2")
//    List<Author> findByFirstNameAndLastName(String firstName, String lastName);

}
