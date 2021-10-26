package com.mon.bbn.repository;

import com.mon.bbn.model.Contestant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContestantRepository extends CrudRepository<Contestant, String> {

    // finding contestants by their tag
    Optional<Contestant> findByTag(String tag);
}
