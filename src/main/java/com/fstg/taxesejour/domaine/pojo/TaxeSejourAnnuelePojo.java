package com.fstg.taxesejour.domaine.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxeSejourAnnuelePojo {
    Long id;
    String refTaxeSejourAnnuele;
    int anneee;
    BigDecimal nombreNuit;
    BigDecimal nombreClients;
    String refLocal;


    List<TaxeSejourTrimPojo> taxeSejourTrims;

    BigDecimal montantRetard;


    Date datePresentation;


    Date dateValidation;
}
