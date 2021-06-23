package com.github.lucasrpb.marvel.repositories;

import com.github.lucasrpb.marvel.models.CharacterModel;
import com.github.lucasrpb.marvel.models.ComicModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarvelCharacterRepository extends CrudRepository<CharacterModel, Integer> {

    @Query("SELECT c FROM CharacterModel c WHERE c.name = ?1")
    CharacterModel findUserByName(String name);

    @Query("select c from CharacterModel cm join cm.comics c where cm.id = ?1")
    List<ComicModel> findComics(int id, Pageable pageable);

}
