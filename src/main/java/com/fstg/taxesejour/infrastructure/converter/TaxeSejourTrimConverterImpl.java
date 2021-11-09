package com.fstg.taxesejour.infrastructure.converter;

import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourTrim;
import org.springframework.stereotype.Component;

@Component
public class TaxeSejourTrimConverterImpl implements TaxeSejourTrimConverter {

    @Override
    public TaxeSejourTrim toEntity(TaxeSejourTrimPojo pojo) {
        TaxeSejourTrim entity = new TaxeSejourTrim();
        updateEntity(entity, pojo);
        return entity;
    }

    @Override
    public TaxeSejourTrimPojo toPojo(TaxeSejourTrim entity) {
        TaxeSejourTrimPojo dto = new TaxeSejourTrimPojo();
        if (entity != null) {
//            converter
        }
        return dto;
    }

    @Override
    public TaxeSejourTrim updateEntity(TaxeSejourTrim entity, TaxeSejourTrimPojo pojo) {
        if (entity != null && pojo != null) {
//           converter
        }
        return entity;
    }
}
