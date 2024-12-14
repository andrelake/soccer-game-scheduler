package com.andrelake.soccer_game_scheduler.api.services;

import com.andrelake.soccer_game_scheduler.api.domain.Match;
import com.andrelake.soccer_game_scheduler.api.domain.dto.MatchDTO;
import com.andrelake.soccer_game_scheduler.api.repositories.MatchRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match save(MatchDTO dto) {
        Match matchToSave = Match.toMatch(dto);
        return matchRepository.save(matchToSave);
    }


    public MatchDTO getById(Long id) {
        return matchRepository.findById(id)
                .map(MatchDTO::toMatchDTO)
                .orElseThrow(() -> new EntityNotFoundException("Match not found"));
    }

}