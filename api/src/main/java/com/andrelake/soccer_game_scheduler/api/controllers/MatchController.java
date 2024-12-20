package com.andrelake.soccer_game_scheduler.api.controllers;

import com.andrelake.soccer_game_scheduler.api.controllers.dto.CreateMatchRequest;
import com.andrelake.soccer_game_scheduler.api.domain.dto.MatchDTO;
import com.andrelake.soccer_game_scheduler.api.services.MatchService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }


    @PostMapping("/create")
    public MatchDTO createMatch(@RequestBody @Valid CreateMatchRequest request) {
        MatchDTO matchDTO = MatchDTO.toMatchDTO(request);
        return matchService.save(matchDTO);
    }


    @GetMapping("/{id}")
    public MatchDTO findById(@PathVariable Long id) {
        return matchService.getById(id);
    }

    @PostMapping("/addPlayer")
    public String addPlayerToMatch(@RequestParam Long matchId,
                                   @RequestParam Long playerId) {
        return matchService.addPlayerToMatch(matchId, playerId);
    }

}
