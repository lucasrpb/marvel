package com.github.lucasrpb.marvel.services;

import com.github.lucasrpb.marvel.api.models.*;
import com.github.lucasrpb.marvel.models.*;
import com.github.lucasrpb.marvel.repositories.MarvelCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CharacterService {

    @Autowired
    private MarvelCharacterRepository characterRepo;

    protected MarvelCharacter getCharacterData(CharacterModel c) {
        MarvelCharacter mc = new MarvelCharacter();

        mc.setName(c.getName());
        mc.setDescription(c.getDescription());
        mc.setModified(c.getModified());
        mc.setId(c.getId());
        mc.setResourceURI(c.getResourceURI());
        mc.setUrls(c.getUrls());
        mc.setThumbnail(c.getThumbnail());

        ComicList comicList = new ComicList();
        comicList.setCollectionURI("ComicCollectionURI");

        List<ComicSummary> comicItems = new ArrayList<>();
        PageRequest pr = PageRequest.of(0, 20);

        List<ComicModel> comics = characterRepo.findComics(c.getId(), pr);

        for(ComicModel cm: comics){
            ComicSummary cs = new ComicSummary();

            cs.setName(cm.getTitle());
            cs.setResourceURI(cm.getResourceURI());

            comicItems.add(cs);
        }

        comicList.setItems(comicItems);

        comicList.setAvailable(comicItems.size());
        comicList.setReturned(comicItems.size());

        mc.setComics(comicList);

        StoryList storyList = new StoryList();
        storyList.setCollectionURI("StoryCollectionURI");

        List<StorySummary> storyItems = new ArrayList<>();
        pr = PageRequest.of(0, 20);

        List<StoryModel> stories = characterRepo.findStories(c.getId(), pr);

        for(StoryModel sm: stories){
            StorySummary ss = new StorySummary();

            ss.setName(sm.getTitle());
            ss.setResourceURI(sm.getResourceURI());

            storyItems.add(ss);
        }

        storyList.setItems(storyItems);

        storyList.setAvailable(storyItems.size());
        storyList.setReturned(storyItems.size());

        mc.setStories(storyList);

        EventList eventList = new EventList();
        eventList.setCollectionURI("EventCollectionURI");

        List<EventSummary> eventItems = new ArrayList<>();
        pr = PageRequest.of(0, 20);

        List<EventModel> events = characterRepo.findEvents(c.getId(), pr);

        for(EventModel sm: events){
            EventSummary es = new EventSummary();

            es.setName(sm.getTitle());
            es.setResourceURI(sm.getResourceURI());

            eventItems.add(es);
        }

        eventList.setItems(eventItems);

        eventList.setAvailable(eventItems.size());
        eventList.setReturned(eventItems.size());

        mc.setEvents(eventList);

        SeriesList seriesList = new SeriesList();
        seriesList.setCollectionURI("SeriesCollectionURI");

        List<SeriesSummary> seriesItems = new ArrayList<>();
        pr = PageRequest.of(0, 20);

        List<SeriesModel> series = characterRepo.findSeries(c.getId(), pr);

        for(SeriesModel sm: series){
            SeriesSummary ss = new SeriesSummary();

            ss.setName(sm.getTitle());
            ss.setResourceURI(sm.getResourceURI());

            seriesItems.add(ss);
        }

        seriesList.setItems(seriesItems);

        seriesList.setAvailable(seriesItems.size());
        seriesList.setReturned(seriesItems.size());

        mc.setSeries(seriesList);

        return mc;
    }

    public CharacterModel create(CharacterModel c){
        return characterRepo.save(c);
    }

    public List<CharacterDataWrapper> findAllCharacters(String name, int limit){
        Iterator<CharacterModel> it;
        List<CharacterDataWrapper> data = new ArrayList<>();

        PageRequest pr = PageRequest.of(0, limit);

        if(name != null){
            CharacterModel model = characterRepo.findUserByName(name);
            it = model != null ? Collections.singleton(model).iterator() : Collections.emptyIterator();
        } else {
            it = characterRepo.findAll(pr).iterator();
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
            results.add(getCharacterData(it.next()));
        }

        cdc.setResults(results);

        cdc.setCount(results.size());
        cdc.setLimit(limit);
        cdc.setOffset(0);
        cdc.setTotal(results.size());

        cdw.setData(cdc);
        data.add(cdw);

        return data;
    }

    public Optional<MarvelCharacter> findCharacterById(Integer id){
       Optional<CharacterModel> c = characterRepo.findById(id);
       if(c.isPresent()) return Optional.of(getCharacterData(c.get()));

       return Optional.empty();
    }

}
