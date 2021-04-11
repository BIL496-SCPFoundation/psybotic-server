package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.models.Article;
import com.scpfoundation.psybotic.server.repositories.ArticleRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IArticleService;
import com.scpfoundation.psybotic.server.types.AgeRange;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService extends CRUDService<ArticleRepository, Article> implements IArticleService {

    private final ArticleRepository repository;

    public ArticleService(ArticleRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<Article> findByAgeRange(AgeRange ageRange, int count) {
        List<Article> articles = repository.findByAgeRange(ageRange);
        if (articles.size() > count) {
            return articles.subList(0, count);
        } else return articles;
    }

}
