package com.fstg.taxesejour.application.rest.api;


import com.fstg.taxesejour.application.dto.TaxeSejourTrimDtoResponse;
import com.fstg.taxesejour.domaine.pojo.TaxeSejourAnnuelePojo;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourAnnuele;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.fstg.taxesejour.utils.Constant.TAXE_ANNUEL_ENDPOINT;

@Api("Taxe Sejour Annuel Api")
public interface TaxeSejourAnnuelApi {

    @PostMapping(value = TAXE_ANNUEL_ENDPOINT + "/")
    @ApiOperation(value = "Add new TaxeSejourAnnuele", notes = "Add new TaxeSejourAnnuele", response = Integer.class)
    int save(@RequestBody TaxeSejourAnnuele taxeSejourAnnuele);

    @GetMapping(value = TAXE_ANNUEL_ENDPOINT + "/")
    @ApiOperation(value = "findAll", notes = "findAll", response = TaxeSejourTrimDtoResponse.class)
    List<TaxeSejourAnnuelePojo> findAll();

    @GetMapping(value = TAXE_ANNUEL_ENDPOINT + "/ref/{ref}")
    @ApiOperation(value = "findByRef", notes = "findByRef", response = TaxeSejourTrimDtoResponse.class)
    TaxeSejourAnnuelePojo findByRef(@PathVariable String ref);

    @GetMapping(value = TAXE_ANNUEL_ENDPOINT + "/annee/{annee}")
    @ApiOperation(value = "findByAnnee", notes = "findByAnnee", response = TaxeSejourTrimDtoResponse.class)
    TaxeSejourAnnuelePojo findByAnnee(@PathVariable int annee);
}
