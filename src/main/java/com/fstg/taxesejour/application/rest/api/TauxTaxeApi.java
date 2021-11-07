package com.fstg.taxesejour.application.rest.api;


import com.fstg.taxesejour.application.dto.TauxTaxeSejourVO;
import com.fstg.taxesejour.application.dto.TaxeSejourAnnuelVO;
import com.fstg.taxesejour.domaine.process.impl.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.fstg.taxesejour.utils.Constant.TAUX_TAXE;


@Api("Taxe Sejour Annuel Api")
@RequestMapping(value = TAUX_TAXE)
public interface TauxTaxeApi {

    @PostMapping(value = "/")
    @ApiOperation(value = "Add new tauxTaxeSejour", notes = "Add new tauxTaxeSejour", response = Integer.class)
    Result save(@RequestBody TauxTaxeSejourVO tauxTaxeSejourVO);

    @GetMapping(value = "/")
    @ApiOperation(value = "findAll", notes = "findAll", response = TaxeSejourAnnuelVO.class)
    List<TaxeSejourAnnuelVO> findAll();

//    @GetMapping(value = "/ref/{ref}")
//    @ApiOperation(value = "findByRef", notes = "findByRef", response = TaxeSejourAnnuelVO.class)
//    TaxeSejourAnnuelVO findByRef(@PathVariable String ref);

}
