package com.fstg.taxesejour.application.rest;

import com.fstg.taxesejour.application.rest.api.TauxTaxeApi;
import com.fstg.taxesejour.domaine.process.facade.TauxTaxeSejourService;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TauxTaxeController implements TauxTaxeApi {
    private final TauxTaxeSejourService tauxTaxeSejourService;
    private final ModelMapper modelMapper;


    public TauxTaxeController(TauxTaxeSejourService tauxTaxeSejourService, ModelMapper modelMapper) {
        this.tauxTaxeSejourService = tauxTaxeSejourService;
        this.modelMapper = modelMapper;
    }
    @Override
    public int save(TauxTaxeSejour tauxTaxeSejour) {
        tauxTaxeSejourService.save(tauxTaxeSejour);
        log.info("test");
        return 1;
    }

    @Override
    public List<TauxTaxeSejour> findAll() {
        return tauxTaxeSejourService.findAll();
    }

    @Override
    public TauxTaxeSejour findByRef(String ref) {
        return tauxTaxeSejourService.findByRef(ref);
    }
}
