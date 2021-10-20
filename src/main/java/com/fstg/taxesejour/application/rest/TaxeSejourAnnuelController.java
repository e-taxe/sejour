package com.fstg.taxesejour.application.rest;

import com.fstg.taxesejour.application.rest.api.TaxeSejourAnnuelApi;
import com.fstg.taxesejour.domaine.pojo.TaxeSejourAnnuelePojo;
import com.fstg.taxesejour.domaine.service.core.TaxeSejourAnnuelService;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourAnnuele;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaxeSejourAnnuelController implements TaxeSejourAnnuelApi {
    private final TaxeSejourAnnuelService taxeSejourAnnuelService;

    public TaxeSejourAnnuelController(TaxeSejourAnnuelService taxeSejourAnnuelService) {
        this.taxeSejourAnnuelService = taxeSejourAnnuelService;
    }

    @Override
    public TaxeSejourAnnuelePojo save(TaxeSejourAnnuele taxeSejourAnnuele) {
        return taxeSejourAnnuelService.save(taxeSejourAnnuele);
    }

    @Override
    public List<TaxeSejourAnnuelePojo> findAll() {
        return taxeSejourAnnuelService.findAll();
    }

    @Override
    public TaxeSejourAnnuelePojo findByRef(String ref) {
        return taxeSejourAnnuelService.findByRef(ref);
    }

    @Override
    public TaxeSejourAnnuelePojo findByAnnee(int annee) {
        return taxeSejourAnnuelService.findByAnnee(annee);
    }
}
