package com.codegym.repository;

import java.util.List;

public interface ArticleRepository<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}
