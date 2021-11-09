package com.fstg.taxesejour.application.rest;

import com.fstg.taxesejour.application.rest.api.TaxeSejourTrimApi;
import com.fstg.taxesejour.domaine.core.Result;
import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.domaine.taxeSejourTrim.create.CreateTaxeTrimInput;
import com.fstg.taxesejour.domaine.taxeSejourTrim.create.CreateTaxeTrimProcess;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxTaxeSejourInfra;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import com.fstg.taxesejour.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
public class TaxeSejourTrimController implements TaxeSejourTrimApi {


    private final CreateTaxeTrimProcess createTaxeTrimProcess;
    private final TauxTaxeSejourInfra tauxTaxeSejourInfra;

    public TaxeSejourTrimController(CreateTaxeTrimProcess createTaxeTrimProcess, TauxTaxeSejourInfra tauxTaxeSejourInfra) {
        this.createTaxeTrimProcess = createTaxeTrimProcess;
        this.tauxTaxeSejourInfra = tauxTaxeSejourInfra;
    }

    @Override
    public Result save(TaxeSejourTrimPojo taxeSejourTrim) {
        CreateTaxeTrimInput createTaxeTrimInput = new CreateTaxeTrimInput();
        createTaxeTrimInput.setTaxeSejourTrimPojo(taxeSejourTrim);
        return createTaxeTrimProcess.execute(createTaxeTrimInput);
    }

    @Override
    public TauxTaxeSejour getTauxByCurrnetDate(String date) {
        TauxTaxeSejour tauxTaxeSejour = tauxTaxeSejourInfra.getCurrentTauxTaxe(Utils.dateToString(new Date()));
//        log.info("valeur {}", tauxTaxeSejour);
        return tauxTaxeSejour;
    }
}
