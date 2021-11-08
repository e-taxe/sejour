package com.fstg.taxesejour.application.rest.api;


import com.fstg.taxesejour.application.dto.TaxeSejourAnnuelDto;
import com.fstg.taxesejour.domaine.core.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.fstg.taxesejour.utils.Constant.TAXE_ANNUEL_ENDPOINT;

@Api("Taxe Sejour Annuel Api")
@RequestMapping(value = TAXE_ANNUEL_ENDPOINT)
public interface TaxeSejourAnnuelApi {

    @PostMapping(value = "/")
    @ApiOperation(value = "Add new TaxeSejourAnnuele", notes = "Add new TaxeSejourAnnuele", response = Integer.class)
    Result save(@RequestBody TaxeSejourAnnuelDto TaxeSejourAnnuelDto);

//    @GetMapping(value = "/")
//    @ApiOperation(value = "findAll", notes = "findAll", response = TaxeSejourAnnuelDto.class)
//    List<TaxeSejourAnnuelDto> findAll();
//
//    @GetMapping(value = "/ref/{ref}")
//    @ApiOperation(value = "findByRef", notes = "findByRef", response = TaxeSejourAnnuelDto.class)
//    TaxeSejourAnnuelDto findByRef(@PathVariable String ref);
//
//    @GetMapping(value = "/annee/{annee}")
//    @ApiOperation(value = "findByAnnee", notes = "findByAnnee", response = TaxeSejourAnnuelDto.class)
//    TaxeSejourAnnuelDto findByAnnee(@PathVariable int annee);
}
