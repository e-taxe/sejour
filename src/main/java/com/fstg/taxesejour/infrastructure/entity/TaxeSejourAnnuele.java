package com.fstg.taxesejour.infrastructure.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "taxeSejourAnnuele")
public class TaxeSejourAnnuele extends AbstractEntity {
    int anneee;
    BigDecimal nombreNuit;
    BigDecimal nombreClients;
}
