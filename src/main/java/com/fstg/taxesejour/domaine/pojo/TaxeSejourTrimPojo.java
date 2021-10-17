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
    String refTaxeSejourTrim;
    int numTrim;
    int annee;
    BigDecimal nombreNuit;
    BigDecimal montant;
    BigDecimal montantRetard;
    TaxeSejourAnnuelePojo taxeSejourAnnuele;
    Date datePresentation;
    Date dateValidation;

}
