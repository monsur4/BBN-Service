package com.mon.bbn.service;

import com.mon.bbn.model.Contestant;
import com.mon.bbn.repository.ContestantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ContestantServiceImpl implements ContestantService {

    private final ContestantRepository contestantRepository;

    @Autowired
    public ContestantServiceImpl(ContestantRepository contestantRepository){
        this.contestantRepository = contestantRepository;
    }

    @Override
    public Contestant addContestant(Contestant contestant) {
        log.info("--- adding contestant  {} ---", contestant);
        return contestantRepository.save(contestant);
    }

    @Override
    public Contestant findContestantById(String id) {
        Optional<Contestant> contestant = contestantRepository.findById(id);
        return contestant.orElse(null);
    }

    @Override
    public Contestant findContestantByTag(String tag) {
        return contestantRepository.findByTag(tag).orElse(null);
    }

    @Override
    public List<Contestant> getAllContestants() {
        return (List<Contestant>)contestantRepository.findAll();
    }

    /**
     * implementation of the update method looks similar to the save method, but this may change
     */
    @Override
    public Contestant updateContestant(Contestant contestant) {
        return contestantRepository.save(contestant);
    }

    @Override
    public void deleteContestantById(String id) {
        log.info("--- deleting contestant  {} ---", id);
        contestantRepository.deleteById(id);
    }
}
