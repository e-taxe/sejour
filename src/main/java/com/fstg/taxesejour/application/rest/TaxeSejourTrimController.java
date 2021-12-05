package com.fstg.taxesejour.application.rest;

import com.fstg.taxesejour.application.dto.TaxeSejourTrimDto;
import com.fstg.taxesejour.application.rest.api.TaxeSejourTrimApi;
import com.fstg.taxesejour.domaine.core.Result;
import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.domaine.process.taxeSejourTrim.create.CreateTaxeTrimProcess;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxTaxeSejourInfra;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import com.fstg.taxesejour.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TaxeSejourTrimController implements TaxeSejourTrimApi {


    private final CreateTaxeTrimProcess createTaxeTrimProcess;
    private final TauxTaxeSejourInfra tauxTaxeSejourInfra;
    private final ModelMapper modelMapper;

    @Override
    public List<TaxeSejourTrimDto> findAll() {
        return tauxTaxeSejourInfra.findAll().stream().map(el -> modelMapper.map(el, TaxeSejourTrimDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Result save(TaxeSejourTrimDto taxeSejourTrim) {
        TaxeSejourTrimPojo taxeSejourTrimPojo = modelMapper.map(taxeSejourTrim, TaxeSejourTrimPojo.class);
        log.info("data {}", taxeSejourTrimPojo);
        return createTaxeTrimProcess.execute(taxeSejourTrimPojo);
    }

    @Override
    public TauxTaxeSejour getTauxByCurrnetDate(String date) {
        TauxTaxeSejour tauxTaxeSejour = tauxTaxeSejourInfra.getCurrentTauxTaxe(Utils.dateToString(new Date()));
//        log.info("valeur {}", tauxTaxeSejour);
        return tauxTaxeSejour;
    }
}
