package com.codegym.service;

import com.codegym.model.Article;
import com.codegym.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ArticleServiceImpl implements ArticleService<Article>{
    @Autowired
    private ArticleRepository<Article> articleArticleRepository;
    @Override
    public List<Article> findAll() {
        return articleArticleRepository.findAll();
    }

    @Override
    public Article findById(Long id) {
        return articleArticleRepository.findById(id);
    }

    @Override
    public void save(Article article) {
        articleArticleRepository.save(article);
    }

    @Override
    public void remove(Long id) {
        articleArticleRepository.remove(id);
    }
}
