package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ArticleRepository;
import com.example.entity.Article;

@RestController
public class ArticleController {
    @Autowired
    ArticleRepository articleRepostitory;

    @PostMapping("/addArticle")
    public String addArticle(String title, Object content, String tag) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setTag(tag);
        return String.valueOf(articleRepostitory.save(article).getArticleId());// 返回id做验证
    }

    @DeleteMapping("/deleteArticle")
    public String deleteArticle(Long articleId) {
        articleRepostitory.deleteById(articleId);
        return "Success!";
    }

    @PutMapping("/updateArticle")
    public String updateArticle(Long articleId, String title, String content, String tag) {
        Article article = new Article();
        article.setArticleId(articleId);
        article.setTitle(title);
        article.setContent(content);
        article.setTag(tag);
        return String.valueOf(articleRepostitory.save(article).getArticleId());// 返回id做验证
    }

    @GetMapping("/getArticle")
    public Article getArticle(Long ArticleId) {
        return articleRepostitory.findById(ArticleId).get();
    }

    @GetMapping("/getAllArticle")
    public Iterable<Article> getAllArticle() {
        return articleRepostitory.findAll();
    }
}