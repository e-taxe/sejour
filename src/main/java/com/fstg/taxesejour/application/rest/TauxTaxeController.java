package com.fstg.taxesejour.application.rest;

import com.fstg.taxesejour.application.dto.TauxTaxeSejourDto;
import com.fstg.taxesejour.application.rest.api.TauxTaxeApi;
import com.fstg.taxesejour.domaine.core.Result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class TauxTaxeController implements TauxTaxeApi {


    @Override
    public Result save(TauxTaxeSejourDto tauxTaxeSejourDto) {
        return null;
    }
}
