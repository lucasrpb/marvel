package com.github.lucasrpb.marvel.controllers;

import com.github.lucasrpb.marvel.api.models.*;
import com.github.lucasrpb.marvel.models.*;
import com.github.lucasrpb.marvel.repositories.MarvelCharacterRepository;
import com.github.lucasrpb.marvel.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Controller
@EnableJpaRepositories("com.github.lucasrpb.marvel.repositories")
/*@EntityScan("com.github.lucasrpb.marvel.models")*/
@RequestMapping("/v1/public/characters")
public class MarvelCharacterController {

    public MarvelCharacterController(CharacterService service) {
        this.service = service;
    }

    @Autowired
    private CharacterService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<CharacterDataWrapper>> findAll(@RequestParam(name = "name", required = false) String name,
                                                                  @RequestParam(name = "limit", required = false) Integer limit) {

        List<CharacterDataWrapper> data = new ArrayList<>();

        Iterator<CharacterModel> it;

        if(name != null && (name.isEmpty() || name.isBlank())){
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        if(limit != null && limit > 100){
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(service.findAllCharacters(name, limit != null ? limit : 20), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MarvelCharacter> findById(@PathVariable(name = "id", required = true) Integer id) {
        Optional<MarvelCharacter> c = service.findCharacterById(id);

        if(c.isPresent()) {
            return new ResponseEntity<>(c.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CharacterModel create(@RequestBody CharacterModel c) {
        return service.create(c);
    }

}
