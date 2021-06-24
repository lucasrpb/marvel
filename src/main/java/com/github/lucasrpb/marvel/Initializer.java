package com.github.lucasrpb.marvel;

import com.github.lucasrpb.marvel.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Initializer {

    @Autowired
    CharacterService characterService;

    @PostConstruct
    public synchronized void init() {
        Helper.populate(characterService);
    }
}
