package com.fstg.taxesejour.infrastructure.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "taxeSejourTrim")
@Builder
public class TaxeSejourTrim extends AbstractEntity {
    int numTrim;
    int annee;
    String ref;
    BigDecimal nombreNuit;
    BigDecimal montant;
    BigDecimal montantRetard;
    @ManyToOne()
    TaxeSejourAnnuele taxeSejourAnnuele;
    @Temporal(TemporalType.DATE)
    Date datePresentation;
//
//    @Temporal(TemporalType.DATE)
//    @Transient
//    Date expectedDatePresentation;

    //    @Temporal(TemporalType.DATE)
//    Date dateValidation;
    @ManyToOne()
    TauxTaxeSejour tauxTaxeSejour;
    @OneToOne(optional = true)
    TauxRetardTaxeSejourTrim tauxRetardTaxeSejourTrim;

}
