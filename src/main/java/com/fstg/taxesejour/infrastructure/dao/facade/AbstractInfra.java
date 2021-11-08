package com.fstg.taxesejour.infrastructure.dao.facade;

import java.util.List;

public interface AbstractInfra<T, K> {
    T save(T entity);

    List<T> findAll();

    String getMessage(String code);
}
