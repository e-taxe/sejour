package com.fstg.taxesejour.application.rest;

import com.fstg.taxesejour.application.dto.TaxeSejourTrimDtoRequest;
import com.fstg.taxesejour.application.dto.TaxeSejourTrimDtoResponse;
import com.fstg.taxesejour.application.rest.api.TaxeSejourTrimApi;
import com.fstg.taxesejour.domaine.pojo.Local;
import com.fstg.taxesejour.domaine.service.core.TaxeSejourTrimService;
import com.fstg.taxesejour.domaine.service.required.LocalService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TaxeSejourTrimController implements TaxeSejourTrimApi {

    private final TaxeSejourTrimService taxeSejourTrimService;
    private final ModelMapper modelMapper;
    private final LocalService localService;

    public TaxeSejourTrimController(TaxeSejourTrimService taxeSejourTrimService, ModelMapper modelMapper, LocalService localService) {
        this.taxeSejourTrimService = taxeSejourTrimService;
        this.modelMapper = modelMapper;
        this.localService = localService;
    }

    public List<TaxeSejourTrimDtoResponse> findAll() {
        return taxeSejourTrimService.findAll().stream().map(el -> modelMapper.map(el, TaxeSejourTrimDtoResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public TaxeSejourTrimDtoResponse findByRefTaxeSejourTrim(String refTaxeSejourTrim) {
        return modelMapper.map(taxeSejourTrimService.findByRefTaxeSejourTrim(refTaxeSejourTrim), TaxeSejourTrimDtoResponse.class);
    }

    @Override
    public int deleteByRefTaxeSejourTrim(String refTaxeSejourTrim) {
        return taxeSejourTrimService.deleteByRefTaxeSejourTrim(refTaxeSejourTrim);
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
    public TaxeSejourTrimDtoResponse save(TaxeSejourTrimDtoRequest taxeSejourTrimDtoRequest) {
        return modelMapper.map(taxeSejourTrimService.save(taxeSejourTrimDtoRequest), TaxeSejourTrimDtoResponse.class);
    }


    @GetMapping("/locals")
    public List<Local> findAllLocal() {
        return localService.findAll();
    }

    @GetMapping("/locals/ref/{ref}")
    public Local findByRef(@PathVariable String ref) {
        return localService.findByRef(ref);
    }
}
