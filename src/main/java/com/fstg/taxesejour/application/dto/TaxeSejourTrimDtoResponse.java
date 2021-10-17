package com.fstg.taxesejour.application.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxeSejourTrimDtoResponse {
    String refTaxeSejourTrim;
    String numTrim;
    String annee;
    String nombreNuit;
    String montant;
    String montantRetard;
    String taxeSejourAnnuele;
    String datePresentation;
    String dateValidation;
}
