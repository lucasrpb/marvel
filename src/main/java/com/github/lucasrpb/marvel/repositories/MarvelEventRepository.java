package com.github.lucasrpb.marvel.repositories;

import com.github.lucasrpb.marvel.models.EventModel;
import org.springframework.data.repository.CrudRepository;

public interface MarvelEventRepository extends CrudRepository<EventModel, Integer>{}
