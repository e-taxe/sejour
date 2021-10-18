package com.fstg.taxesejour.application.converter;

import com.fstg.taxesejour.application.dto.TaxeSejourTrimDtoRequest;
import com.fstg.taxesejour.application.dto.TaxeSejourTrimDtoResponse;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourTrim;
import com.fstg.taxesejour.utils.Utils;
import org.springframework.stereotype.Component;

@Component
public class TaxeSejourTrimConverter {
    public TaxeSejourTrim voToBean(TaxeSejourTrimDtoRequest taxeSejourTrimDtoRequest) {
        return TaxeSejourTrim.builder()
                .annee(Integer.parseInt(taxeSejourTrimDtoRequest.getAnnee()))
                .refTaxeSejourTrim(taxeSejourTrimDtoRequest.getRefTaxeSejourTrim())
                .numTrim(Integer.parseInt(taxeSejourTrimDtoRequest.getNumTrim()))
                .datePresentation(Utils.stringToDate(taxeSejourTrimDtoRequest.getDatePresentation()))
                .dateValidation(Utils.stringToDate(taxeSejourTrimDtoRequest.getDatePresentation()))
                .montant(Utils.stringToBigDecimal(taxeSejourTrimDtoRequest.getMontant()))
                .montantRetard(Utils.stringToBigDecimal(taxeSejourTrimDtoRequest.getMontantRetard()))
                .build();
    }

    public TaxeSejourTrimDtoResponse voToBean(TaxeSejourTrim taxeSejourTrim) {
        return TaxeSejourTrimDtoResponse.builder()
                .annee(String.valueOf(taxeSejourTrim.getAnnee()))
                .build();
    }
}
