package com.codegym.repository;

import java.util.List;

public interface ArticleRepository<T> {
    List<T>findAll();
    void save(T model);
    T findById(Long id);
    void remove(Long id);
}
