package com.github.lucasrpb.marvel.controllers;

import com.github.lucasrpb.marvel.models.CreatorModel;
import com.github.lucasrpb.marvel.repositories.MarvelCreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
/*@EnableJpaRepositories("com.github.lucasrpb.marvel.repository")
@EntityScan("com.github.lucasrpb.marvel.models")*/
@RequestMapping("/v1/public/creators")
public class MarvelCreatorController {

    @Autowired
    private MarvelCreatorRepository creatorRepo;

    @GetMapping
    public Iterable findAll() {
        return creatorRepo.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatorModel create(@RequestBody CreatorModel c) { return creatorRepo.save(c); }

}
