package com.fstg.taxesejour.application.rest.api;

import com.fstg.taxesejour.application.dto.TaxeSejourTrimDtoResponse;
import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.domaine.process.impl.Result;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourTrim;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.fstg.taxesejour.utils.Constant.TAXE_TRIM_ENDPOINT;

@Api("Taxe Sejour Trim Api")
public interface TaxeSejourTrimApi {
    @GetMapping(value = TAXE_TRIM_ENDPOINT + "/")
    @ApiOperation(value = "Get All Taxe Trim ", notes = "All Taxe Trim", response = TaxeSejourTrimDtoResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All Taxe Trim")
    })
    List<TaxeSejourTrimDtoResponse> findAll();

    @GetMapping(value = TAXE_TRIM_ENDPOINT + "/ref/{ref}")
    @ApiOperation(value = "Taxe Trim By Refrence", notes = "Taxe Trim By Refrence", response = TaxeSejourTrimDtoResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Taxe Trim By Refrence")
    })
    TaxeSejourTrimDtoResponse findByReferance(@PathVariable String ref);


    @DeleteMapping(value = TAXE_TRIM_ENDPOINT + "/ref/{ref}")
    @ApiOperation(value = "Delete Taxe Trim By Refrence", notes = "Delete Taxe Trim By Refrence", response = TaxeSejourTrimDtoResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Delete Taxe Trim By Refrence")
    })
    int deleteByRef(@PathVariable String ref);

    @GetMapping(value = TAXE_TRIM_ENDPOINT + "/year/{year}")
    @ApiOperation(value = "Find Taxe Trim By year", notes = "Find Taxe Trim By year", response = TaxeSejourTrimDtoResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Find Taxe Trim By year")
    })
    TaxeSejourTrimDtoResponse findByAnnee(@PathVariable() int year);


    @GetMapping(value = TAXE_TRIM_ENDPOINT + "/dateValidation/{dateValidation}")
    @ApiOperation(value = "Find Taxe Trim By Date Validation", notes = "Find Taxe Trim By Date Validation", response = TaxeSejourTrimDtoResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Find Taxe Trim By Date Validation")
    })
    TaxeSejourTrimDtoResponse findByDateValidation(@PathVariable() Date dateValidation);

    @PostMapping(value = TAXE_TRIM_ENDPOINT + "/")
    @ApiOperation(value = "Add new Taxe", notes = "Add new Taxe Sejour", response = Integer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Add new Taxe Sejour")
    })
    Result save(@RequestBody TaxeSejourTrimPojo taxeSejourTrim);
}
