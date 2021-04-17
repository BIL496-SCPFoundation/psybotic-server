package com.scpfoundation.psybotic.server.controllers;

import com.scpfoundation.psybotic.server.models.Article;
import com.scpfoundation.psybotic.server.serviceInterfaces.IArticleService;
import com.scpfoundation.psybotic.server.types.AgeRange;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
@CrossOrigin("*")
public class ArticleController extends CRUDController<IArticleService, Article>{
    private final IArticleService articleService;

    public ArticleController(IArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/findByAgeRange")
    public List<Article> findByAgeRange(@RequestParam("ageRange") AgeRange ageRange, @RequestParam("count") int count) {
        return articleService.findByAgeRange(ageRange, count);
    }
}
