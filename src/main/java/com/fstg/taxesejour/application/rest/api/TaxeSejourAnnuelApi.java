package com.fstg.taxesejour.application.rest.api;


import com.fstg.taxesejour.application.dto.TaxeSejourAnnuelVO;
import com.fstg.taxesejour.domaine.process.impl.Result;
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
    Result save(@RequestBody TaxeSejourAnnuelVO TaxeSejourAnnuelVO);

    @GetMapping(value = "/")
    @ApiOperation(value = "findAll", notes = "findAll", response = TaxeSejourAnnuelVO.class)
    List<TaxeSejourAnnuelVO> findAll();

    @GetMapping(value = "/ref/{ref}")
    @ApiOperation(value = "findByRef", notes = "findByRef", response = TaxeSejourAnnuelVO.class)
    TaxeSejourAnnuelVO findByRef(@PathVariable String ref);

    @GetMapping(value = "/annee/{annee}")
    @ApiOperation(value = "findByAnnee", notes = "findByAnnee", response = TaxeSejourAnnuelVO.class)
    TaxeSejourAnnuelVO findByAnnee(@PathVariable int annee);
}
