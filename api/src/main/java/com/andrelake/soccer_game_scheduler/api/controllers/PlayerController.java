package com.andrelake.soccer_game_scheduler.api.controllers;

import com.andrelake.soccer_game_scheduler.api.controllers.dto.CreatePlayerRequest;
import com.andrelake.soccer_game_scheduler.api.domain.Player;
import com.andrelake.soccer_game_scheduler.api.domain.dto.PlayerDTO;
import com.andrelake.soccer_game_scheduler.api.services.PlayerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @PostMapping("/create")
    public Player createPlayer(@RequestBody @Valid CreatePlayerRequest player) {
        PlayerDTO playerToSave = PlayerDTO.toPlayerDTO(player);
        return playerService.save(playerToSave);
    }

}
