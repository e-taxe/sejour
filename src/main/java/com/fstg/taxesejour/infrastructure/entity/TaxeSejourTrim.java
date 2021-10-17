package com.fstg.taxesejour.infrastructure.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "taxeSejourTrim")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaxeSejourTrim extends AbstractEntity {
    @Id
    Long id;
    String refTaxeSejourTrim;
    int numTrim;
    int annee;
    BigDecimal nombreNuit;
    BigDecimal montant;
    BigDecimal montantRetard;
    @ManyToOne()
    TaxeSejourAnnuele taxeSejourAnnuele;

    @Temporal(TemporalType.DATE)
    Date datePresentation;

    @Temporal(TemporalType.DATE)
    Date dateValidation;


}
