package com.github.lucasrpb.marvel.controllers;

import com.github.lucasrpb.marvel.api.models.*;
import com.github.lucasrpb.marvel.models.CharacterModel;
import com.github.lucasrpb.marvel.models.ComicModel;
import com.github.lucasrpb.marvel.repositories.MarvelCharacterRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@RestController
@EnableJpaRepositories("com.github.lucasrpb.marvel.repositories")
/*@EntityScan("com.github.lucasrpb.marvel.models")*/
@RequestMapping("/v1/public/characters")
public class MarvelCharacterController {

    @Autowired
    private MarvelCharacterRepository characterRepo;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable findAll(@RequestParam(name = "name", required = false) String name) {

        List<CharacterDataWrapper> data = new ArrayList<>();

        Iterator<CharacterModel> it;

        if(name != null && !name.isBlank() && !name.isEmpty()){
            CharacterModel model = characterRepo.findUserByName(name);
            it = model != null ? Collections.singleton(model).iterator() : Collections.emptyIterator();
        } else {
            it = characterRepo.findAll().iterator();
        }

        CharacterDataWrapper cdw = new CharacterDataWrapper();
        cdw.setCode(200);
        cdw.setStatus("Ok");
        cdw.setAttributionHTML("<x></x>");
        cdw.setCopyright("Marvel Inc");
        cdw.setAttributionText("attribution text");

        CharacterDataContainer cdc = new CharacterDataContainer();

        List<MarvelCharacter> results = new ArrayList<>();

        while(it.hasNext()){
            CharacterModel c = it.next();
            MarvelCharacter mc = new MarvelCharacter();

            mc.setName(c.getName());
            mc.setDescription(c.getDescription());
            mc.setModified(c.getModified());
            mc.setId(c.getId());
            mc.setResourceURI(c.getResourceURI());
            mc.setUrls(c.getUrls());
            mc.setThumbnail(c.getThumbnail());

            ComicList comicList = new ComicList();

            comicList.setCollectionURI("collectionURI");

            List<ComicSummary> items = new ArrayList<>();

            PageRequest pr = PageRequest.of(0, 20);

            List<ComicModel> comics = characterRepo.findComics(c.getId(), pr);

            for(ComicModel cm: comics){
                ComicSummary cs = new ComicSummary();

                cs.setName(cm.getTitle());
                cs.setResourceURI(cm.getResourceURI());

                items.add(cs);
            }

            comicList.setItems(items);

            comicList.setAvailable(items.size());
            comicList.setReturned(items.size());

            mc.setComics(comicList);

            results.add(mc);
        }

        cdc.setResults(results);

        cdc.setCount(results.size());
        cdc.setLimit(20);
        cdc.setOffset(0);
        cdc.setTotal(results.size());

        cdw.setData(cdc);
        data.add(cdw);

        return data;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CharacterModel create(@RequestBody CharacterModel c) {
        return characterRepo.save(c);
    }

}
