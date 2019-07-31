package com.codegym.service;

import com.codegym.model.Article;

import java.util.List;

public interface ArticleService<T> {
    List<T> findAll();
    T findById(Long id);
    void save (T model);
    void remove (Long id);
}
