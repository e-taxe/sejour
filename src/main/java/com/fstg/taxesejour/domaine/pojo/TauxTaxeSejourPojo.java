package com.fstg.taxesejour.domaine.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TauxTaxeSejourPojo {
    Date dateMinApplication;
    Date dateMaxApplication;
    Double taux;


}
