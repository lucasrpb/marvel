package com.github.lucasrpb.marvel.repositories;

import com.github.lucasrpb.marvel.models.SeriesModel;
import org.springframework.data.repository.CrudRepository;

public interface MarvelSeriesRepository extends CrudRepository<SeriesModel, Integer>{}
