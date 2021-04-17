package com.scpfoundation.psybotic.server.repositories;

import com.scpfoundation.psybotic.server.models.Article;
import com.scpfoundation.psybotic.server.types.AgeRange;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin("*")
public interface ArticleRepository extends MongoRepository<Article, String> {
    List<Article> findByAgeRange(AgeRange ageRange);
}
