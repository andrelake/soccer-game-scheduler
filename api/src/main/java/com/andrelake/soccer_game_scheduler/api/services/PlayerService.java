package com.andrelake.soccer_game_scheduler.api.services;

import com.andrelake.soccer_game_scheduler.api.domain.Player;
import com.andrelake.soccer_game_scheduler.api.domain.dto.PlayerDTO;
import com.andrelake.soccer_game_scheduler.api.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player save(PlayerDTO player) {
        Player playerToSave = Player.toPlayer(player);
        return playerRepository.save(playerToSave);
    }

}