package com.fstg.taxesejour.infrastructure.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "tauxTaxeSejour")
@Getter
@Setter
public class TauxTaxeSejour extends AbstractEntity {

    @Temporal(TemporalType.DATE)
    Date dateMinApplication;
    @Temporal(TemporalType.DATE)
    Date dateMaxApplication;
    Double taux;
    @OneToMany(mappedBy = "tauxTaxeSejour", cascade = CascadeType.ALL)
    List<TaxeSejourTrim> taxeSejourTrims;

}
