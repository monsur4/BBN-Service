package com.mon.bbn.repository;

import com.mon.bbn.model.Season;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends CrudRepository<Season, Integer> {
}
