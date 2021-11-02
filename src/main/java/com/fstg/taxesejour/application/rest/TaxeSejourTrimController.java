package com.fstg.taxesejour.application.rest;

import com.fstg.taxesejour.application.dto.TaxeSejourTrimDtoResponse;
import com.fstg.taxesejour.application.rest.api.TaxeSejourTrimApi;
import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.domaine.process.facade.CreateTauxTaxeTrimProcess;
import com.fstg.taxesejour.domaine.process.facade.TaxeSejourTrimService;
import com.fstg.taxesejour.domaine.process.impl.Result;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TaxeSejourTrimController implements TaxeSejourTrimApi {

    private final TaxeSejourTrimService taxeSejourTrimService;
    private final ModelMapper modelMapper;
    private final CreateTauxTaxeTrimProcess createTauxTaxeTrimProcess;


    public TaxeSejourTrimController(TaxeSejourTrimService taxeSejourTrimService, ModelMapper modelMapper, CreateTauxTaxeTrimProcess createTauxTaxeTrimProcess) {
        this.taxeSejourTrimService = taxeSejourTrimService;
        this.modelMapper = modelMapper;
        this.createTauxTaxeTrimProcess = createTauxTaxeTrimProcess;
    }

    public List<TaxeSejourTrimDtoResponse> findAll() {
        return taxeSejourTrimService.findAll().stream().map(el -> modelMapper.map(el, TaxeSejourTrimDtoResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public TaxeSejourTrimDtoResponse findByReferance(String ref) {
        return modelMapper.map(taxeSejourTrimService.findByRefTaxeSejourTrim(ref), TaxeSejourTrimDtoResponse.class);
    }

    @Override
    public int deleteByRef(String ref) {
        return taxeSejourTrimService.deleteByRefTaxeSejourTrim(ref);
    }

    @Override
    public TaxeSejourTrimDtoResponse findByAnnee(int annee) {
        return modelMapper.map(taxeSejourTrimService.findByAnnee(annee), TaxeSejourTrimDtoResponse.class);
    }

    @Override
    public TaxeSejourTrimDtoResponse findByDateValidation(Date dateValidation) {
        return modelMapper.map(taxeSejourTrimService.findByDateValidation(dateValidation), TaxeSejourTrimDtoResponse.class);
    }

    @Override
    public Result save(TaxeSejourTrimPojo taxeSejourTrim) {
        return createTauxTaxeTrimProcess.run(taxeSejourTrim);
    }


}
