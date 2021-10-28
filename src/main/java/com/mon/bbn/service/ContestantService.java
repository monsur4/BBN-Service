package com.mon.bbn.service;

import com.mon.bbn.model.Contestant;

import java.util.List;

public interface ContestantService {
    /**
     * create method
     */

    Contestant addContestant(Contestant contestant);

    /**
     * read methods
     */
    Contestant findContestantById(String id);

    Contestant findContestantByTag(String tag);

    List<Contestant> getAllContestants();

    /**
     * update methods
     */
    Contestant updateContestant (Contestant contestant);

    /**
     * delete methods
     */
    void deleteContestantById(String id);
}
