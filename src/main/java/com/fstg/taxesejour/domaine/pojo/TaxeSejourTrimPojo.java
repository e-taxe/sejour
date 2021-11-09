package com.fstg.taxesejour.domaine.pojo;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TaxeSejourTrimPojo {
    Long id;
    String ref;
    int numTrim;
    int annee;
    Long nombreNuit;
    BigDecimal montant;
    BigDecimal montantRetard;
    Date datePresentation;


}
