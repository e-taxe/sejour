package com.fstg.taxesejour.application.rest;

import com.fstg.taxesejour.application.converter.TauxTaxeSejourConverter;
import com.fstg.taxesejour.application.dto.TauxTaxeSejourVO;
import com.fstg.taxesejour.application.dto.TaxeSejourAnnuelVO;
import com.fstg.taxesejour.application.rest.api.TauxTaxeApi;
import com.fstg.taxesejour.domaine.process.facade.TauxTaxeSejourProcess;
import com.fstg.taxesejour.domaine.process.impl.Result;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class TauxTaxeController implements TauxTaxeApi {
    private final TauxTaxeSejourProcess tauxTaxeSejourProcess;
    private final ModelMapper modelMapper;
    private final TauxTaxeSejourConverter tauxTaxeSejourConverter;


    public TauxTaxeController(TauxTaxeSejourProcess tauxTaxeSejourProcess, ModelMapper modelMapper, TauxTaxeSejourConverter tauxTaxeSejourConverter) {
        this.tauxTaxeSejourProcess = tauxTaxeSejourProcess;
        this.modelMapper = modelMapper;
        this.tauxTaxeSejourConverter = tauxTaxeSejourConverter;
    }

    @Override
    public Result save(TauxTaxeSejourVO tauxTaxeSejourVO) {
        TauxTaxeSejour tauxTaxeSejour = tauxTaxeSejourConverter.voToBean(tauxTaxeSejourVO);
        tauxTaxeSejour.setRef(tauxTaxeSejourVO.getRef());
        return tauxTaxeSejourProcess.run(tauxTaxeSejour);
    }

    @Override
    public List<TaxeSejourAnnuelVO> findAll() {
        return tauxTaxeSejourProcess.findAll().stream().map(el -> modelMapper.map(el, TaxeSejourAnnuelVO.class))
                .collect(Collectors.toList());
    }

}
