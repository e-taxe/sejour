package com.fstg.taxesejour.application.rest.api;

import com.fstg.taxesejour.domaine.core.Result;
import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.fstg.taxesejour.utils.Constant.TAXE_TRIM_ENDPOINT;

@Api("Taxe Sejour Trim Api")
@RequestMapping(value = TAXE_TRIM_ENDPOINT)
public interface TaxeSejourTrimApi {
//    @GetMapping(value = "/")
//    @ApiOperation(value = "Get All Taxe Trim ", notes = "All Taxe Trim", response = TaxeSejourTrimDto.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "All Taxe Trim")
//    })
//    List<TaxeSejourTrimDto> findAll();
//
//    @GetMapping(value = "/ref/{ref}")
//    @ApiOperation(value = "Taxe Trim By Refrence", notes = "Taxe Trim By Refrence", response = TaxeSejourTrimDto.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Taxe Trim By Refrence")
//    })
//    TaxeSejourTrimDto findByReferance(@PathVariable String ref);
//
//
//    @DeleteMapping(value = "/ref/{ref}")
//    @ApiOperation(value = "Delete Taxe Trim By Refrence", notes = "Delete Taxe Trim By Refrence", response = TaxeSejourTrimDto.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Delete Taxe Trim By Refrence")
//    })
//    int deleteByRef(@PathVariable String ref);
//
//    @GetMapping(value = "/year/{year}")
//    @ApiOperation(value = "Find Taxe Trim By year", notes = "Find Taxe Trim By year", response = TaxeSejourTrimDto.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Find Taxe Trim By year")
//    })
//    TaxeSejourTrimDto findByAnnee(@PathVariable() int year);
//
//
//    @GetMapping(value = "/dateValidation/{dateValidation}")
//    @ApiOperation(value = "Find Taxe Trim By Date Validation", notes = "Find Taxe Trim By Date Validation", response = TaxeSejourTrimDto.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Find Taxe Trim By Date Validation")
//    })
//    TaxeSejourTrimDto findByDateValidation(@PathVariable() Date dateValidation);

    @PostMapping(value = "/")
    @ApiOperation(value = "Add new Taxe", notes = "Add new Taxe Sejour", response = Integer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Add new Taxe Sejour")
    })
    Result save(@RequestBody TaxeSejourTrimPojo taxeSejourTrim);
}
