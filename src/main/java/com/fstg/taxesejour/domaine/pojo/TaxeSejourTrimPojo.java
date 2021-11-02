package com.fstg.taxesejour.domaine.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxeSejourTrimPojo {
    Long id;
    String ref;
    int numTrim;
    int annee;
    long nombreNuit;
    BigDecimal montant;
    BigDecimal montantRetard;
    String refTaxeSejourAnnuele;
    String refTauxTaxe;
    Date datePresentation;
    Date dateValidation;
    Date expectedDatePresentation;

}
