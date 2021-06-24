package com.github.lucasrpb.marvel.services;

import com.github.lucasrpb.marvel.models.ComicModel;
import com.github.lucasrpb.marvel.repositories.MarvelComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComicService {

    @Autowired
    private MarvelComicRepository comicRepo;

    public ComicModel create(ComicModel c){
        return comicRepo.save(c);
    }

}
