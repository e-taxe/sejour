package com.fstg.taxesejour.application.rest;

import com.fstg.taxesejour.application.rest.api.TaxeSejourTrimApi;
import com.fstg.taxesejour.domaine.core.Result;
import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.domaine.taxeSejourTrim.create.CreateTaxeTrimInput;
import com.fstg.taxesejour.domaine.taxeSejourTrim.create.CreateTaxeTrimProcess;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxeSejourTrimController implements TaxeSejourTrimApi {


    private final CreateTaxeTrimProcess createTaxeTrimProcess;

    public TaxeSejourTrimController(CreateTaxeTrimProcess createTaxeTrimProcess) {
        this.createTaxeTrimProcess = createTaxeTrimProcess;
    }

    @Override
    public Result save(TaxeSejourTrimPojo taxeSejourTrim) {
        CreateTaxeTrimInput createTaxeTrimInput = new CreateTaxeTrimInput();
        createTaxeTrimInput.setTaxeSejourTrimPojo(taxeSejourTrim);
        return createTaxeTrimProcess.execute(createTaxeTrimInput);
    }
}
