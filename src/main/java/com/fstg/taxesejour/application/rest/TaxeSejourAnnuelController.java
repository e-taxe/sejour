package com.fstg.taxesejour.application.rest;

import com.fstg.taxesejour.application.rest.api.TaxeSejourAnnuelApi;
import com.fstg.taxesejour.domaine.pojo.TaxeSejourAnnuelePojo;
import com.fstg.taxesejour.domaine.service.core.TaxeSejourAnnuelService;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourAnnuele;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TaxeSejourAnnuelController implements TaxeSejourAnnuelApi {
    private final TaxeSejourAnnuelService taxeSejourAnnuelService;
    private final ModelMapper modelMapper;

    public TaxeSejourAnnuelController(TaxeSejourAnnuelService taxeSejourAnnuelService, ModelMapper modelMapper) {
        this.taxeSejourAnnuelService = taxeSejourAnnuelService;
        this.modelMapper = modelMapper;
    }

    @Override
    public TaxeSejourAnnuelePojo save(TaxeSejourAnnuele taxeSejourAnnuele) {
        return
                modelMapper.map(taxeSejourAnnuelService.save(taxeSejourAnnuele), TaxeSejourAnnuelePojo.class);
    }

    @Override
    public List<TaxeSejourAnnuelePojo> findAll() {
        return taxeSejourAnnuelService.findAll().stream().map(el -> modelMapper.map(el, TaxeSejourAnnuelePojo.class))
                .collect(Collectors.toList());
    }

    @Override
    public TaxeSejourAnnuelePojo findByRef(String ref) {
        return modelMapper.map(taxeSejourAnnuelService.findByRef(ref), TaxeSejourAnnuelePojo.class);
    }

    @Override
    public TaxeSejourAnnuelePojo findByAnnee(int annee) {
        return modelMapper.map(taxeSejourAnnuelService.findByAnnee(annee), TaxeSejourAnnuelePojo.class);
    }
}
