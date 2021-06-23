package com.github.lucasrpb.marvel.controllers;

import com.github.lucasrpb.marvel.models.SeriesModel;
import com.github.lucasrpb.marvel.repositories.MarvelSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
/*@EnableJpaRepositories("com.github.lucasrpb.marvel.repository")
@EntityScan("com.github.lucasrpb.marvel.models")*/
@RequestMapping("/v1/public/series")
public class MarvelSeriesController {

    @Autowired
    private MarvelSeriesRepository seriesRepo;

    @GetMapping
    public Iterable findAll() {
        return seriesRepo.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SeriesModel create(@RequestBody SeriesModel c) { return seriesRepo.save(c); }

}
