package com.mon.bbn.controller;

import com.mon.bbn.model.Contestant;
import com.mon.bbn.model.User;
import com.mon.bbn.service.ContestantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("application/json")
@RequestMapping("/api/contestants")
@Slf4j
public class ContestantController {

    private final ContestantService contestantService;

    public ContestantController(ContestantService contestantService){
        this.contestantService = contestantService;
    }

    @GetMapping
    public List<Contestant> getAllContestants(){
        return contestantService.getAllContestants();
    }

    @GetMapping("/id/{id}")
    public Contestant getContestantById(@PathVariable("id")String id){
        return contestantService.findContestantById(id);
    }

    @GetMapping("/tag/{tag}")
    public Contestant getContestantByTag(@PathVariable("tag") String tag){
        return contestantService.findContestantByTag(tag);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public Contestant addContestant(@RequestBody Contestant contestant, @AuthenticationPrincipal User user){
        log.info("User {} add contestant {}", user, contestant);
        return contestantService.addContestant(contestant);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasRole('ADMIN')")
    public Contestant updateContestant(@RequestBody Contestant contestant){
        return contestantService.updateContestant(contestant);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteContestant(@RequestBody Contestant contestant){
        contestantService.deleteContestant(contestant);
    }
}
