package com.fstg.taxesejour.infrastructure.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "categories")
@Getter
@Setter
public class CategorieSejour extends AbstractEntity {
    @Id
    Long id;
    String refCategorieSejour;
    @Column(name = "categorie")
    String categorie;

}
