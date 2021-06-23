package com.github.lucasrpb.marvel.repositories;

import com.github.lucasrpb.marvel.models.ComicModel;
import org.springframework.data.repository.CrudRepository;

public interface MarvelComicRepository extends CrudRepository<ComicModel, Integer>{}
