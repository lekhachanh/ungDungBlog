package com.codegym.controller;

import com.codegym.model.Article;
import com.codegym.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/view")
    public ModelAndView findAll() {
        List<Article> articleList = articleService.findAll();
        ModelAndView modelAndView = new ModelAndView("/article/view");
        modelAndView.addObject("articles", articleList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/article/create");
        modelAndView.addObject("article", new Article());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveArticle(@ModelAttribute("article") Article article) {
        articleService.save(article);
        ModelAndView modelAndView = new ModelAndView("/article/create");
        modelAndView.addObject("article", new Article());
        modelAndView.addObject("message", "created!");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Article article = articleService.findById(id);
        if (article != null) {
            ModelAndView modelAndView = new ModelAndView("/article/edit");
            modelAndView.addObject("article", article);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/update")
    public ModelAndView updateArticle(@ModelAttribute("article") Article article) {
        articleService.save(article);
        ModelAndView modelAndView = new ModelAndView("/article/edit");
        modelAndView.addObject("message", "update article successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Article article = articleService.findById(id);
        if (article != null) {
            ModelAndView modelAndView = new ModelAndView("/article/delete");
            modelAndView.addObject("article", article);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/remove")
    public ModelAndView removeArticle(@ModelAttribute("article") Article article){
        articleService.remove(article.getId());
        ModelAndView modelAndView = new ModelAndView("/article/delete");
        modelAndView.addObject("message", "delete article successfully");
        return modelAndView;
    }
}
