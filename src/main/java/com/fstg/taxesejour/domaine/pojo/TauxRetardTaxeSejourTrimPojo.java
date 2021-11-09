package com.fstg.taxesejour.domaine.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TauxRetardTaxeSejourTrimPojo {
    Double premierMoisRetard; // 10DH
    Double autreMoisRetard; // 7DH
    Date dateApplicationMin;
    Date dateApplicationMax;


}
