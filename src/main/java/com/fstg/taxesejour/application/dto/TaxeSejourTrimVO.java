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
public class TaxeSejourTrimVO {
    String ref;
    String numTrim;
    String annee;
    String nombreNuit;
    String refTaxeSejourAnnuel;
    String datePresentation;
}
