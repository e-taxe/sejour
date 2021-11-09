package com.fstg.taxesejour.infrastructure.config;


import com.fstg.taxesejour.domaine.taxeSejourAnnuel.create.CreateTaxeAnnuelProcess;
import com.fstg.taxesejour.domaine.taxeSejourAnnuel.create.CreateTaxeAnnuelProcessImpl;
import com.fstg.taxesejour.domaine.taxeSejourTrim.create.CreateTaxeTrimProcess;
import com.fstg.taxesejour.domaine.taxeSejourTrim.create.CreateTaxeTrimProcessImpl;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxRetardTaxeSejourTrimInfra;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxTaxeSejourInfra;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourAnnuelInfra;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourTrimInfra;
import com.fstg.taxesejour.infrastructure.required.LocalService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public CreateTaxeAnnuelProcess createTaxeAnnuelProcess(
            TaxeSejourAnnuelInfra taxeSejourAnnuelInfra,
            TauxTaxeSejourInfra tauxTaxeSejourInfra,
            LocalService localService
    ) {
        return new CreateTaxeAnnuelProcessImpl(taxeSejourAnnuelInfra, tauxTaxeSejourInfra, localService);
    }

    @Bean
    public CreateTaxeTrimProcess createTaxeTrimProcess(
            TaxeSejourTrimInfra taxeSejourTrimInfra,
            TauxTaxeSejourInfra tauxTaxeSejourInfra,
            TauxRetardTaxeSejourTrimInfra tauxRetardTaxeSejourTrimInfra
    ) {
        return new CreateTaxeTrimProcessImpl(taxeSejourTrimInfra, tauxTaxeSejourInfra, tauxRetardTaxeSejourTrimInfra);
    }





}
