package com.fstg.taxesejour.application.rest.api;


import com.fstg.taxesejour.application.dto.TaxeSejourTrimDtoResponse;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.fstg.taxesejour.utils.Constant.TAUX_TAXE;


@Api("Taxe Sejour Annuel Api")
public interface TauxTaxeApi {

    @PostMapping(value = TAUX_TAXE + "/")
    @ApiOperation(value = "Add new tauxTaxeSejour", notes = "Add new tauxTaxeSejour", response = Integer.class)
    int save(@RequestBody TauxTaxeSejour tauxTaxeSejour);

    @GetMapping(value = TAUX_TAXE + "/")
    @ApiOperation(value = "findAll", notes = "findAll", response = TaxeSejourTrimDtoResponse.class)
    List<TauxTaxeSejour> findAll();

    @GetMapping(value = TAUX_TAXE + "/ref/{ref}")
    @ApiOperation(value = "findByRef", notes = "findByRef", response = TaxeSejourTrimDtoResponse.class)
    TauxTaxeSejour findByRef(@PathVariable String ref);

}
