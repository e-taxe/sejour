package com.fstg.taxesejour.application.rest.api;

import com.fstg.taxesejour.application.dto.TaxeSejourTrimDtoRequest;
import com.fstg.taxesejour.application.dto.TaxeSejourTrimDtoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api("Taxe Sejour Trim Api")
public interface TaxeSejourTrimApi {
    @GetMapping(value = "/taxe-sejour")
    @ApiOperation(value = "Get All Taxe Trim ", notes = "All Taxe Trim", response = TaxeSejourTrimDtoResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All Taxe Trim")
    })
    List<TaxeSejourTrimDtoResponse> findAll();

    @GetMapping(value = "/taxe-sejour/byRefrence/{refTaxeSejourTrim}")
    @ApiOperation(value = "Taxe Trim By Refrence", notes = "Taxe Trim By Refrence", response = TaxeSejourTrimDtoResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Taxe Trim By Refrence")
    })
    TaxeSejourTrimDtoResponse findByRefTaxeSejourTrim(@PathVariable String refTaxeSejourTrim);

    @DeleteMapping(value = "/taxe-sejour/byRefrence/{refTaxeSejourTrim}")
    @ApiOperation(value = "Delete Taxe Trim By Refrence", notes = "Delete Taxe Trim By Refrence", response = TaxeSejourTrimDtoResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Delete Taxe Trim By Refrence")
    })
    int deleteByRefTaxeSejourTrim(@PathVariable String refTaxeSejourTrim);

    @GetMapping(value = "/taxe-sejour/byYear/{annee}")
    @ApiOperation(value = "Find Taxe Trim By year", notes = "Find Taxe Trim By year", response = TaxeSejourTrimDtoResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Find Taxe Trim By year")
    })
    TaxeSejourTrimDtoResponse findByAnnee(@PathVariable() int annee);

    @GetMapping(value = "/taxe-sejour/byDateValidation/{dateValidation}")
    @ApiOperation(value = "Find Taxe Trim By Date Validation", notes = "Find Taxe Trim By Date Validation", response = TaxeSejourTrimDtoResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Find Taxe Trim By Date Validation")
    })
    TaxeSejourTrimDtoResponse findByDateValidation(@PathVariable() Date dateValidation);

    @PostMapping(value = "/taxe-sejour")
    @ApiOperation(value = "Add new Taxe", notes = "Add new Taxe Sejour", response = TaxeSejourTrimDtoResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Add new Taxe Sejour")
    })
    TaxeSejourTrimDtoResponse save(@RequestBody TaxeSejourTrimDtoRequest taxeSejourTrimDtoRequest);
}
