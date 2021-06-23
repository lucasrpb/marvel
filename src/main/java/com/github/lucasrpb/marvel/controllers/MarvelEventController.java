package com.github.lucasrpb.marvel.controllers;

import com.github.lucasrpb.marvel.models.EventModel;
import com.github.lucasrpb.marvel.repositories.MarvelEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
/*@EnableJpaRepositories("com.github.lucasrpb.marvel.repository")
@EntityScan("com.github.lucasrpb.marvel.models")*/
@RequestMapping("/v1/public/events")
public class MarvelEventController {

    @Autowired
    private MarvelEventRepository eventRepo;

    @GetMapping
    public Iterable findAll() {
        return eventRepo.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventModel create(@RequestBody EventModel c) { return eventRepo.save(c); }

}
