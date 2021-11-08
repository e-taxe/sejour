package com.fstg.taxesejour.infrastructure.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "tauxRetardTaxeSejourTrim")
@Data
@Builder
public class TauxRetardTaxeSejourTrim extends AbstractEntity {
    Double premierMoisRetard;
    Double autreMoisRetard;
    //    int nombreMoisRetard;
    @Temporal(TemporalType.DATE)
    Date dateApplicationMin;
    Date dateApplicationMax;
//    Double montant;
}
