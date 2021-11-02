package com.fstg.taxesejour.infrastructure.dao.facade;

import java.util.List;

public interface AbstractDao<T, K> {
    T save(T entity);

    List<T> findAll();
    
}
