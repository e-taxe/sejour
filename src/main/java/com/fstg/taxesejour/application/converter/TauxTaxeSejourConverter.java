package com.fstg.taxesejour.application.converter;

import com.fstg.taxesejour.application.dto.TauxTaxeSejourVO;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import com.fstg.taxesejour.utils.Utils;
import org.springframework.stereotype.Component;

@Component
public class TauxTaxeSejourConverter {

    public TauxTaxeSejour voToBean(TauxTaxeSejourVO tauxTaxeSejourVO) {
        return TauxTaxeSejour.builder()
                .taux(Double.parseDouble(tauxTaxeSejourVO.getTaux()))
                .dateMinApplication(Utils.stringToDate(tauxTaxeSejourVO.getDateMinApplication()))
                .dateMaxApplication(Utils.stringToDate(tauxTaxeSejourVO.getDateMaxApplication()))
                .build();
    }
}
