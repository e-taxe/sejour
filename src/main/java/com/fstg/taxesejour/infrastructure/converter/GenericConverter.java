package com.fstg.taxesejour.infrastructure.converter;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface GenericConverter<E, P> {
    //E Entity
    // P POJO
    E toEntity(P pojo);

    P toPojo(E entity);

    default P toPojoTest(E entity) {
        for (Field fieldDto : entity.getClass().getDeclaredFields()) {
            try {
                PropertyDescriptor pdGet = new PropertyDescriptor(fieldDto.getName(), this.getClass());
                PropertyDescriptor pdSet = new PropertyDescriptor(fieldDto.getName(), entity.getClass());
                Object newInstance = pdSet.getPropertyType().newInstance();
                Object obj = pdGet.getReadMethod().invoke((P) this);
                pdSet.getWriteMethod().invoke(entity, ((GenericConverter<E, P>) obj).toPojoTest((E) newInstance));
            } catch (IntrospectionException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return P;
    }

    E updateEntity(E entity, P pojo);

    default List<P> createFromEntities(final Collection<E> entities) {
        return entities.stream()
                .map(this::toPojo)
                .collect(Collectors.toList());
    }

    default List<E> createFromPojo(final Collection<P> pojos) {
        return pojos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
