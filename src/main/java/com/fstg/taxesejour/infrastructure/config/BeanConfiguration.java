package com.fstg.taxesejour.infrastructure.config;

import com.fstg.taxesejour.domaine.process.facade.CreateTauxTaxeTrimProcess;
import com.fstg.taxesejour.domaine.process.facade.TauxTaxeSejourService;
import com.fstg.taxesejour.domaine.process.facade.TaxeSejourAnnuelService;
import com.fstg.taxesejour.domaine.process.facade.TaxeSejourTrimService;
import com.fstg.taxesejour.domaine.process.impl.CreateTauxTaxeTrimProcessImpl;
import com.fstg.taxesejour.domaine.process.impl.TauxTaxeSejourServiceImpl;
import com.fstg.taxesejour.domaine.process.impl.TaxeSejourAnnuelServiceImpl;
import com.fstg.taxesejour.domaine.process.impl.TaxeSejourTrimServiceImpl;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxRetardTaxeSejourTrimDao;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxTaxeSejourDao;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourAnnuelDao;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourTrimDao;
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
    TauxTaxeSejourService tauxTaxeSejourService(final TauxTaxeSejourDao tauxTaxeSejourDao) {
        return new TauxTaxeSejourServiceImpl(tauxTaxeSejourDao);
    }

    @Bean
    CreateTauxTaxeTrimProcess createTauxTaxeTrimProcess(final TaxeSejourTrimDao taxeSejourTrimDao,
                                                        final TaxeSejourAnnuelDao taxeSejourAnnuelDao,
                                                        final TauxTaxeSejourDao tauxTaxeSejourDao,
                                                        final TauxRetardTaxeSejourTrimDao tauxRetardTaxeSejourTrimDao
    ) {
        return new CreateTauxTaxeTrimProcessImpl(taxeSejourTrimDao, taxeSejourAnnuelDao, tauxTaxeSejourDao, tauxRetardTaxeSejourTrimDao);
    }
}
