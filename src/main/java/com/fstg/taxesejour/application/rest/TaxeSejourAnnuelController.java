package com.fstg.taxesejour.application.rest;

import com.fstg.taxesejour.application.dto.TaxeSejourAnnuelDto;
import com.fstg.taxesejour.application.rest.api.TaxeSejourAnnuelApi;
import com.fstg.taxesejour.domaine.core.Result;
import com.fstg.taxesejour.domaine.taxeSejourAnnuel.create.CreateTaxeAnnuelInput;
import com.fstg.taxesejour.domaine.taxeSejourAnnuel.create.CreateTaxeAnnuelProcess;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxeSejourAnnuelController implements TaxeSejourAnnuelApi {
    private final CreateTaxeAnnuelProcess createTaxeAnnuelProcess;

    public TaxeSejourAnnuelController(CreateTaxeAnnuelProcess createTaxeAnnuelProcess) {
        this.createTaxeAnnuelProcess = createTaxeAnnuelProcess;
    }

    @Override
    public Result save(TaxeSejourAnnuelDto TaxeSejourAnnuelDto) {
        CreateTaxeAnnuelInput createTaxeAnnuelInput = new CreateTaxeAnnuelInput();
        createTaxeAnnuelInput.setTaxeSejourAnnuelDto(TaxeSejourAnnuelDto);
        return createTaxeAnnuelProcess.execute(createTaxeAnnuelInput);
    }
}
