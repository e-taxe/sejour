package com.fstg.taxesejour.application.converter;

import com.fstg.taxesejour.application.dto.TaxeSejourTrimVO;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourTrim;
import org.springframework.stereotype.Component;

@Component
public class TaxeSejourTrimConverter {
    public TaxeSejourTrim voToBean(TaxeSejourTrimVO taxeSejourTrimDtoVO) {
        return TaxeSejourTrim.builder()
                .annee(Integer.parseInt(taxeSejourTrimDtoVO.getAnnee()))
                .ref(taxeSejourTrimDtoVO.getRef())
                .numTrim(Integer.parseInt(taxeSejourTrimDtoVO.getNumTrim()))
                .build();
    }

}
