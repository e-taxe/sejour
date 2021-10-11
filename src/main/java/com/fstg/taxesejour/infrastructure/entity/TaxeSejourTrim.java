package com.fstg.taxesejour.infrastructure.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity(name = "taxeSejourTrim")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxeSejourTrim extends AbstractEntity {
    private static final long serialVersionUID = 2890912867868119480L;
    int numTrim;
    int annee;
    BigDecimal nombreNuit;
    BigDecimal montant;
    BigDecimal montantRetard;

}
