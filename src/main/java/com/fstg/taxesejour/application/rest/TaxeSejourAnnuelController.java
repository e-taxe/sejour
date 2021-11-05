package com.fstg.taxesejour.application.rest;

import com.fstg.taxesejour.application.rest.api.TaxeSejourAnnuelApi;
import com.fstg.taxesejour.domaine.pojo.TaxeSejourAnnuelePojo;
import com.fstg.taxesejour.domaine.process.facade.CreateTauxTaxeAnnuelProcess;
import com.fstg.taxesejour.domaine.process.facade.TaxeSejourAnnuelService;
import com.fstg.taxesejour.domaine.process.impl.Result;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TaxeSejourAnnuelController implements TaxeSejourAnnuelApi {
    private final TaxeSejourAnnuelService taxeSejourAnnuelService;
    private final ModelMapper modelMapper;
    private final CreateTauxTaxeAnnuelProcess createTauxTaxeAnnuelProcess;

    public TaxeSejourAnnuelController(TaxeSejourAnnuelService taxeSejourAnnuelService, ModelMapper modelMapper, CreateTauxTaxeAnnuelProcess createTauxTaxeAnnuelProcess) {
        this.taxeSejourAnnuelService = taxeSejourAnnuelService;
        this.modelMapper = modelMapper;
        this.createTauxTaxeAnnuelProcess = createTauxTaxeAnnuelProcess;
    }

    @Override
    public Result save(TaxeSejourAnnuelePojo taxeSejourAnnuele) {
        return  createTauxTaxeAnnuelProcess.run(taxeSejourAnnuele);
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
