package com.fstg.taxesejour.domaine.pojo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class TauxRetardTaxeSejourTrimPojo {
    Long id;
    Double premierMoisRetard; // 10DH
    Double autreMoisRetard; // 7DH
    Date dateApplicationMin;
    Date dateApplicationMax;


}
