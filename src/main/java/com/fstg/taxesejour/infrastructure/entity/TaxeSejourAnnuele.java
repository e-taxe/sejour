package com.fstg.taxesejour.infrastructure.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "taxeSejourAnnuele")
public class TaxeSejourAnnuele extends AbstractEntity {
    int annee;
    BigDecimal nombreNuit;
    @OneToMany(mappedBy = "taxeSejourAnnuele", cascade = CascadeType.ALL)
    List<TaxeSejourTrim> taxeSejourTrims = new ArrayList<>();
    BigDecimal montantRetard;
    String refLocal;
    @Temporal(TemporalType.DATE)
    Date datePresentation;
    @Temporal(TemporalType.DATE)
    Date dateValidation;
}
