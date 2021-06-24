package com.github.lucasrpb.marvel.repositories;

import com.github.lucasrpb.marvel.models.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public interface MarvelCharacterRepository extends CrudRepository<CharacterModel, Integer> {

    List<CharacterModel> findAll(Pageable pageable);

    @Query("SELECT c FROM CharacterModel c WHERE c.name = ?1")
    CharacterModel findUserByName(String name);

    @Query("SELECT c FROM CharacterModel c WHERE c.id = ?1")
    CharacterModel findById(int id);

    @Query("select c from CharacterModel cm join cm.comics c where cm.id = ?1")
    List<ComicModel> findComics(int id, Pageable pageable);

    @Query("select s from CharacterModel cm join cm.stories s where cm.id = ?1")
    List<StoryModel> findStories(int id, Pageable pageable);

    @Query("select e from CharacterModel cm join cm.events e where cm.id = ?1")
    List<EventModel> findEvents(int id, Pageable pageable);

    @Query("select s from CharacterModel cm join cm.series s where cm.id = ?1")
    List<SeriesModel> findSeries(int id, Pageable pageable);

}
