package com.fstg.taxesejour.infrastructure.config;

import com.fstg.taxesejour.domaine.repository.TaxeSejourAnnuelDao;
import com.fstg.taxesejour.domaine.repository.TaxeSejourTrimDao;
import com.fstg.taxesejour.domaine.service.core.TaxeSejourAnnuelService;
import com.fstg.taxesejour.domaine.service.core.TaxeSejourTrimService;
import com.fstg.taxesejour.domaine.serviceImpl.TaxeSejourAnnuelServiceImpl;
import com.fstg.taxesejour.domaine.serviceImpl.TaxeSejourTrimServiceImpl;
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
}
