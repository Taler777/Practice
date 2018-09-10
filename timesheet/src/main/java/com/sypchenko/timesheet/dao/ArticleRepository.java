package com.sypchenko.timesheet.dao;

import com.sypchenko.timesheet.model.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {
}