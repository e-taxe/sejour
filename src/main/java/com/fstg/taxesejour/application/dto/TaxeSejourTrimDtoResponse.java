package com.fstg.taxesejour.application.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaxeSejourTrimDtoResponse {
    String ref;
    String numTrim;
    String annee;
    String nombreNuit;
    String montant;
    String montantRetard;
    String taxeSejourAnnuele;
    String datePresentation;
    String dateValidation;
}
