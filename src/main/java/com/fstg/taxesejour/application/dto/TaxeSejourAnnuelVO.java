package com.fstg.taxesejour.application.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxeSejourAnnuelVO {

    String dateMinApplication;
    String dateMaxApplication;
    String taux;
    String ref;

}
