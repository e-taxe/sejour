package com.fstg.taxesejour.application.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxeSejourAnnuelDto {
    Long id;
    String ref;
    int annee;
    BigDecimal nombreNuit;
    String refLocal;
    Date datePresentation;

}
