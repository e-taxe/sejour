package com.fstg.taxesejour.application.converter;

import com.fstg.taxesejour.application.dto.TaxeSejourTrimDtoRequest;
import com.fstg.taxesejour.application.dto.TaxeSejourTrimDtoResponse;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourTrim;
import org.springframework.stereotype.Component;

@Component
public class TaxeSejourTrimConverter {
    public TaxeSejourTrim voToBean(TaxeSejourTrimDtoRequest taxeSejourTrimDtoRequest) {
        return TaxeSejourTrim.builder()
                .annee(Integer.parseInt(taxeSejourTrimDtoRequest.getAnnee()))
                .ref(taxeSejourTrimDtoRequest.getRef())
                .numTrim(Integer.parseInt(taxeSejourTrimDtoRequest.getNumTrim()))
                .build();
    }

    public TaxeSejourTrimDtoResponse voToBean(TaxeSejourTrim taxeSejourTrim) {
        return TaxeSejourTrimDtoResponse.builder()
                .annee(String.valueOf(taxeSejourTrim.getAnnee()))
                .build();
    }
}
