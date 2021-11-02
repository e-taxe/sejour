package com.fstg.taxesejour.infrastructure.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "tauxRetardTaxeSejourTrim")
@Data
@Builder
public class TauxRetardTaxeSejourTrim extends AbstractEntity {
    BigDecimal premierMoisRetard;
    BigDecimal autreMoisRetard;
    int nombreMoisRetard;
    @Temporal(TemporalType.DATE)
    Date dateApplication;
}
