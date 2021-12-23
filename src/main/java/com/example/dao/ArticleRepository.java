package com.example.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.entity.Article;

public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {

	
}
