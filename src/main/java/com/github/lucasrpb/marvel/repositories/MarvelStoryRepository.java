package com.github.lucasrpb.marvel.repositories;

import com.github.lucasrpb.marvel.models.StoryModel;
import org.springframework.data.repository.CrudRepository;

public interface MarvelStoryRepository extends CrudRepository<StoryModel, Integer>{}
