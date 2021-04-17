package com.scpfoundation.psybotic.server.serviceInterfaces;

import com.scpfoundation.psybotic.server.models.Article;
import com.scpfoundation.psybotic.server.types.AgeRange;

import java.util.List;

public interface IArticleService extends ICRUDService<Article, String>{
    public List<Article> findByAgeRange(AgeRange ageRange, int count);
}
