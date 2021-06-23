package com.github.lucasrpb.marvel.controllers;

import com.github.lucasrpb.marvel.models.ComicModel;
import com.github.lucasrpb.marvel.repositories.MarvelComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
/*@EnableJpaRepositories("com.github.lucasrpb.marvel.repository")
@EntityScan("com.github.lucasrpb.marvel.models")*/
@RequestMapping("/v1/public/comics")
public class MarvelComicController {

    @Autowired
    private MarvelComicRepository comicRepo;

    @GetMapping
    public Iterable findAll() {
        return comicRepo.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComicModel create(@RequestBody ComicModel c) {
        System.out.println("hi");
        return comicRepo.save(c);
    }

}
