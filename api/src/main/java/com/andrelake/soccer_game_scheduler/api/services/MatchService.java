package com.andrelake.soccer_game_scheduler.api.services;

import com.andrelake.soccer_game_scheduler.api.domain.Match;
import com.andrelake.soccer_game_scheduler.api.domain.Player;
import com.andrelake.soccer_game_scheduler.api.domain.dto.MatchDTO;
import com.andrelake.soccer_game_scheduler.api.domain.dto.PlayerDTO;
import com.andrelake.soccer_game_scheduler.api.repositories.MatchRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final PlayerService playerService;

    public MatchService(MatchRepository matchRepository, PlayerService playerService) {
        this.matchRepository = matchRepository;
        this.playerService = playerService;
    }

    @Transactional
    public MatchDTO save(MatchDTO dto) {
        Match matchToSave = Match.toMatch(dto);
        Match saved = matchRepository.save(matchToSave);
        return MatchDTO.toMatchDTO(saved);
    }

    public MatchDTO getById(Long id) {
        return matchRepository.findById(id)
                .map(MatchDTO::toMatchDTO)
                .orElseThrow(() -> new EntityNotFoundException("Match not found"));
    }

    @Transactional
    public String addPlayerToMatch(Long matchId, Long playerId) {
        Match match = matchRepository.findById(matchId)
                .orElse(null);

        if (match == null) {
            return "Match not found";
        }

        PlayerDTO player = playerService.findPlayerById(playerId);
        match.getPlayers().add(Player.toPlayer(player));

        matchRepository.save(match);

        return "Player " + player.getName() + " added to the match.";
    }

}