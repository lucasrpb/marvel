package com.github.lucasrpb.marvel.controllers;

import com.github.lucasrpb.marvel.models.StoryModel;
import com.github.lucasrpb.marvel.repositories.MarvelStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
/*@EnableJpaRepositories("com.github.lucasrpb.marvel.repository")
@EntityScan("com.github.lucasrpb.marvel.models")*/
@RequestMapping("/v1/public/stories")
public class MarvelStoryController {

    @Autowired
    private MarvelStoryRepository storiesRepo;

    @GetMapping
    public Iterable findAll() {
        return storiesRepo.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StoryModel create(@RequestBody StoryModel c) { return storiesRepo.save(c); }

}
