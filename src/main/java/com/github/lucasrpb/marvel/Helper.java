package com.github.lucasrpb.marvel;

import com.github.lucasrpb.marvel.models.*;
import com.github.lucasrpb.marvel.services.CharacterService;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Helper {

    static ThreadLocalRandom rand = ThreadLocalRandom.current();

    static void populate(CharacterService characterService){

        List<CharacterModel> characters = new ArrayList<>();

        for(int j=1; j<10; j++){
            CharacterModel c = new CharacterModel();

            c.setId(j);
            c.setName("Lucas-"+j);
            c.setResourceURI("https://lucasrpb"+j+".com");
            c.setDescription("Best Hero"+j+"!");
            c.setModified(Date.from(Instant.now()));
            c.setThumbnail(new ImageModel("profile", "png"));
            c.setUrls(Collections.singletonList(new UrlModel("t", "/profile")));

            List<ComicModel> comics = new ArrayList<>();
            int n = rand.nextInt(1, 21);

            for(int i = 1; i < n; i++){
                ComicModel comic = new ComicModel();

                comic.setTitle("Comic"+i);
                comic.setDescription("Best comic-"+i);

                comics.add(comic);
            }

            c.setComics(comics);

            List<StoryModel> stories = new ArrayList<>();
            n = rand.nextInt(1, 21);

            for(int i = 1; i < n; i++){
                StoryModel story = new StoryModel();

                story.setTitle("Story"+i);
                story.setDescription("story-"+i);

                stories.add(story);
            }

            List<EventModel> events = new ArrayList<>();
            n = rand.nextInt(1, 21);

            for(int i = 1; i < n; i++){
                EventModel event = new EventModel();

                event.setTitle("Event"+i);
                event.setDescription("event-"+i);

                events.add(event);
            }

            List<SeriesModel> seriesList = new ArrayList<>();
            n = rand.nextInt(1, 21);

            for(int i = 1; i < n; i++){
                SeriesModel series = new SeriesModel();

                series.setTitle("Series"+i);
                series.setDescription("series-"+i);

                seriesList.add(series);
            }

            c.setSeries(seriesList);
            c.setComics(comics);
            c.setStories(stories);
            c.setEvents(events);

            characters.add(c);
        }

        for(CharacterModel c: characters){
            characterService.create(c);
        }

    }

}
