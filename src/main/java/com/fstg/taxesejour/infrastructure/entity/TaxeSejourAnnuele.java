package com.fstg.taxesejour.infrastructure.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "taxeSejourAnnuele")
public class TaxeSejourAnnuele extends AbstractEntity {
    @Id
    Long id;
    String refTaxeSejourAnnuele;
    int anneee;
    BigDecimal nombreNuit;
    BigDecimal nombreClients;
    String refLocal;

    @OneToMany(mappedBy = "taxeSejourAnnuele")
    List<TaxeSejourTrim> taxeSejourTrims;

    BigDecimal montantRetard;

    @Temporal(TemporalType.DATE)
    Date datePresentation;

    @Temporal(TemporalType.DATE)
    Date dateValidation;
}
