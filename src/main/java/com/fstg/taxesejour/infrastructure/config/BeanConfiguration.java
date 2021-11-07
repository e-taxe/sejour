package com.fstg.taxesejour.infrastructure.config;

import com.fstg.taxesejour.domaine.process.facade.*;
import com.fstg.taxesejour.domaine.process.impl.*;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxRetardTaxeSejourTrimDao;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxTaxeSejourDao;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourAnnuelDao;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourTrimDao;
import com.fstg.taxesejour.infrastructure.required.LocalService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    TaxeSejourTrimService taxeSejourTrimService(final TaxeSejourTrimDao taxeSejourTrimDao, final ModelMapper modelMapper) {
        return new TaxeSejourTrimServiceImpl(taxeSejourTrimDao, modelMapper);
    }

    @Bean
    TaxeSejourAnnuelService taxeSejourAnnuelService(final TaxeSejourAnnuelDao taxeSejourAnnuelDao, final ModelMapper modelMapper) {
        return new TaxeSejourAnnuelServiceImpl(taxeSejourAnnuelDao, modelMapper);
    }

    @Bean
    TauxTaxeSejourProcess tauxTaxeSejourService(final TauxTaxeSejourDao tauxTaxeSejourDao) {
        return new TauxTaxeSejourProcessImpl(tauxTaxeSejourDao);
    }



    @Bean
    CreateTauxTaxeTrimProcess createTauxTaxeTrimProcess(final TaxeSejourTrimDao taxeSejourTrimDao,
                                                        final TaxeSejourAnnuelDao taxeSejourAnnuelDao,
                                                        final TauxTaxeSejourDao tauxTaxeSejourDao,
                                                        final TauxRetardTaxeSejourTrimDao tauxRetardTaxeSejourTrimDao
    ) {
        return new CreateTauxTaxeTrimProcessImpl(taxeSejourTrimDao, taxeSejourAnnuelDao, tauxTaxeSejourDao, tauxRetardTaxeSejourTrimDao);
    }


    @Bean
    CreateTauxTaxeAnnuelProcess createTauxTaxeAnnuelProcess(
            final TaxeSejourAnnuelDao taxeSejourAnnuelDao,
            final LocalService localService,
            final TauxTaxeSejourDao tauxTaxeSejourDao) {
        return new CreateTauxTaxeAnnuelProcessImpl(taxeSejourAnnuelDao, tauxTaxeSejourDao, localService);
    }
}
