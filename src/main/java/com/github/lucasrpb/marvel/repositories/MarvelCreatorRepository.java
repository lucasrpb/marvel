package com.github.lucasrpb.marvel.repositories;

import com.github.lucasrpb.marvel.models.CreatorModel;
import org.springframework.data.repository.CrudRepository;

public interface MarvelCreatorRepository extends CrudRepository<CreatorModel, Integer>{}
