package com.codegym.controller;

import com.codegym.model.Article;
import com.codegym.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @GetMapping("/view")
    public ModelAndView findAll(){
        List<Article> articleList = articleService.findAll();
        ModelAndView modelAndView = new ModelAndView("article/view");
        modelAndView.addObject("articles", articleList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("/article/create");
        modelAndView.addObject("article", new Article());
        return modelAndView;
    }
}
